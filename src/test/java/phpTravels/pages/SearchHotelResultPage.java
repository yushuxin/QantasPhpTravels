package phpTravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.MyWebDriver;

public class SearchHotelResultPage extends PageObjectBase {

  public SearchHotelResultPage(MyWebDriver driver) {
    super(driver);
  }

  public void clickHotelName(String hotelName) {
    click(By.xpath("//a[text()='" + hotelName + "']"));
    sleep(1);
  }

}
