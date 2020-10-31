package phpTravels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.MyWebDriver;

public class LoginPage extends PageObjectBase {

  public LoginPage(MyWebDriver driver) {
    super(driver);
  }

  public void inputEmail(String password) {
    WebElement emailElement = driver.findElement(By.name("username"));
    emailElement.sendKeys(password);
  }

  public void inputPassword(String password) {
    WebElement passwordElement = driver.findElement(By.name("password"));
    passwordElement.sendKeys(password);
  }

  public void clickLogin() {
    WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
    loginButton.click();
    sleep(2);
  }

}
