package phpTravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import support.MyWebDriver;

public class SearchHotelTab extends PageObjectBase {

  public SearchHotelTab(MyWebDriver driver) {
    super(driver);
  }

  public void setDestination(String destination) {
    By destinationBy = By.xpath("//div[contains(@class, 'hotelsearch locationlistHotels')]");
    waitForElementDisplayed(10, destinationBy);
    WebElement destinationDiv = driver.findElement(destinationBy);
    destinationDiv.click();
    WebElement destinationInput = driver.findElement(By.xpath(
        "//div[contains(@class, 'select2-drop-active')]//input[contains(@class, 'select2-input')]"));
    destinationInput.sendKeys(destination);
    sleep(2);
    destinationInput.sendKeys(Keys.ENTER);
  }

  public void clickSearch() {
    By searchButtonBy = By.xpath("//form[@name='HOTELS']//button[@type='submit']");
    waitForElementEnabled(2, searchButtonBy);
    WebElement searchButton = driver.findElement(searchButtonBy);
    searchButton.click();
    sleep(2);
  }

}
