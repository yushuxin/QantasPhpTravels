package phpTravels.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JScrollBar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.MyWebDriver;

public class PageObjectBase {

  //region Fields
  protected MyWebDriver driver;

  protected String containerXpath = null;

  public Logger log;
  //endregion

  public PageObjectBase() {
  }

  public PageObjectBase(MyWebDriver driver) {
    this.driver = driver;
    log = LogManager.getLogger(this.getClass());
  }

  public WebDriver getDriver() {
    return driver;
  }

//    public void waitForPageLoaded(WebDriver driver) throws Exception {
////        TimeUnit.SECONDS.sleep(5);
////        throw new UnsupportedOperationException("Method has NOT been implemented!");
//        String popupPleaseWaitXpath = "//h1[text()='Please Wait']";
//        boolean popupWindowIsDisplayed = true;
//        log.info("Wait for progress bar:");
//        StopWatch timer = new StopWatch();
//        timer.start();
//        while (popupWindowIsDisplayed && (timer.getTime() < 60000)) {
//          log.info(".");
//          try {
//                WebElement popupWindow = CwDriverUtil.findElement(driver, By.xpath(popupPleaseWaitXpath), null, 1,
//                        true, false, CwDriverUtil.NO_EXCEPTION,
//                        "Waiting for page loaded ");
//                popupWindowIsDisplayed = popupWindow != null;
//            } catch (Exception e) {
//                popupWindowIsDisplayed = false;
//            }
//        }
//        timer.stop();
//        log.info("Time taken: " + timeTransfer(timer.getTime()));
//    }

  public List<String> getDropdownOptions(WebElement dropdownElement) {
    List<String> result = new ArrayList<>();
    Select select = new Select(dropdownElement);
    select.getOptions().forEach(element -> result.add(element.getText()));
    return result;
  }

  public List<String> getDropdownSelectedOptions(WebElement dropdownElement) {
    List<String> result = new ArrayList<>();
    Select select = new Select(dropdownElement);
    select.getAllSelectedOptions().forEach(element -> result.add(element.getText()));
    return result;
  }

  public boolean waitForElementDisplayed(int timeout, By by) {
    try {
      new WebDriverWait(driver, timeout).until(
          (ExpectedCondition<Boolean>) d -> d.findElement(by).isDisplayed());
      return true;
    } catch (Throwable t) {
      return false;
    }
  }

  public boolean waitForElementEnabled(int timeout, By by) {
    try {
      new WebDriverWait(driver, timeout).until(
          (ExpectedCondition<Boolean>) d -> d.findElement(by).isEnabled());
      return true;
    } catch (Throwable t) {
      return false;
    }
  }

  public void scrollIntoView(WebElement element) {
    scrollIntoView(element, 0);
  }

  public void scrollIntoView(WebElement element, int offset) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
    if (offset != 0) {
      ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, " + offset + ")");
    }
  }

  public void sleep(int sec) {
    try {
      TimeUnit.SECONDS.sleep(sec);
    } catch (InterruptedException e) {
      log.info(e, e);
    }
  }

  public void click(By by) {
    waitForElementDisplayed(10, by);
    WebElement element = driver.findElement(by);
    element.click();
  }

}
