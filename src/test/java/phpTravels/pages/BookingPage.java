package phpTravels.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.MyWebDriver;

public class BookingPage extends PageObjectBase {

  public BookingPage(MyWebDriver driver) {
    super(driver);
  }

  public void clickConfirmThisBooking() {
    By confirmThisBookingButtonBy = By.xpath("//button[contains(text(), 'CONFIRM THIS BOOKING')]");
    waitForElementDisplayed(10, confirmThisBookingButtonBy);
    WebElement confirmThisBookingButton = driver.findElement(confirmThisBookingButtonBy);
    scrollIntoView(confirmThisBookingButton, -100);
    confirmThisBookingButton.click();
    sleep(10);
  }


}
