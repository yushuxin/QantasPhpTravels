package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import support.MyWebDriver;

public class WebDriverHooks {

  private MyWebDriver myWebDriver;

  public WebDriverHooks(MyWebDriver myWebDriver) {
    this.myWebDriver = myWebDriver;
  }

  @After
  public void finish(Scenario scenario) {
    try {
      byte[] screenshot =
          myWebDriver.getScreenshotAs(OutputType.BYTES);
      scenario.attach(screenshot, "image/png","screenshot");
    }
    catch (WebDriverException e) {
      System.out.println(e.getMessage());
      if (!(e instanceof NoSuchSessionException)) {
        myWebDriver.close();
      }
      myWebDriver =null;
    }
    finally {
      if (myWebDriver != null) {
        myWebDriver.close();
      }
    }

  }

}