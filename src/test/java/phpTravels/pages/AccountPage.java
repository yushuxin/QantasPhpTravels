package phpTravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.MyWebDriver;

public class AccountPage extends PageObjectBase {

  public AccountPage(MyWebDriver driver) {
    super(driver);
  }

  public boolean verifyBookingExist(String hotelName) {
    return waitForElementDisplayed(10,
        By.xpath("//div[@class='row' and .//a/b[text()='" + hotelName + "']]"));
  }

  public void clickHomeLink() {
    click(By.xpath("//a[text()='Home']"));
    sleep(10);
  }

}
