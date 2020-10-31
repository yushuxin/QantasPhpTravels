package phpTravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.MyWebDriver;

public class HomePage extends PageObjectBase {

  public HomePage(MyWebDriver driver) {
    super(driver);
  }

  public void clickLoginDropDown() {
    WebElement loginDropDown = driver
        .findElement(By.xpath("//div[contains(@class,'dropdown-login')]"));
    loginDropDown.click();
    sleep(1);
  }

  public void clickAccountItem() {
    click(By.xpath("//a[contains(@class,'dropdown-item') and text()='Account']"));
    sleep(5);
  }

}
