package phpTravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.MyWebDriver;

public class HotelDetailPage extends PageObjectBase {

  public HotelDetailPage(MyWebDriver driver) {
    super(driver);
  }

  public void clickSeePriceAndDate() {
    click(By.xpath("//a[contains(text(), 'See price and date')]"));
    sleep(1);
  }

  public void selectRoom(String roomName) {
    By selectRoomLabelBy = By.xpath(
        "//div[@class='room-item' and .//a[text()='" + roomName + "']]//label[contains(text(), 'Select Room')]");
    waitForElementDisplayed(2, selectRoomLabelBy);
    WebElement selectRoomCheckBox = driver.findElement(selectRoomLabelBy);
    selectRoomCheckBox.click();
  }

  public void clickBookNow(){
    WebElement bookNowButton = driver.findElement(By.xpath("//button[contains(text(), 'Book Now')]"));
    scrollIntoView(bookNowButton, -100);
    bookNowButton.click();
  }

}
