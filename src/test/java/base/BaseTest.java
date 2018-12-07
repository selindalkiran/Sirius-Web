package base;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.Browser;

import javax.security.auth.login.Configuration;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by olcayekin on 16/06/2017.
 */
public class BaseTest {
    public static WebDriver driver;
    private String methodName = null;
    protected static final Logger log = Logger.getLogger(BaseTest.class);
    //protected static Configuration config = Configuration.getInstance();
    protected static Browser browser = new Browser();
    public static Boolean isTestinium = false;

    public static void setUp() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        PropertyConfigurator.configure("properties/log4j.properties");
        log.info("Settings Installation Start");

        String KEY = "selidalk:b15114635d227239a56cf3934f10e075";
        capabilities.setCapability("key", KEY);
        if (StringUtils.isEmpty(System.getenv("key"))){
            browser.createLocalDriver();
        }
        else {
            try {
                capabilities.setCapability("takesScreenshot", true);
                log.info("takesScreenshot");
                isTestinium = true;
                setDriver(new RemoteWebDriver(new URL("http://hub.testinium.io/wd/hub"), capabilities));
            } catch (MalformedURLException e) {
                log.error(e.getMessage());
            }

        }
    }


    public static void tearDown(){
        getDriver().quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(RemoteWebDriver driver) {
        BaseTest.driver = driver;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

}
