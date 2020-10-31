package support;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MyWebDriver extends EventFiringWebDriver {

  public MyWebDriver() {
    super(new ChromeDriver());
  }

}
