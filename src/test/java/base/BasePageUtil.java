package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageUtil {
    protected WebDriver driver;
    protected WebDriverWait wait;
   // protected WaitingActions wa;
    protected final Logger log = Logger.getLogger(getClass());

    public BasePageUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);

    }
    protected void navigateTo(String url) {
        driver.navigate().to(url);
    }
}
