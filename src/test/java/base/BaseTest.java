package base;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Browser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static RemoteWebDriver driver;
    private String methodName = null;
    protected static final Logger log = Logger.getLogger(BaseTest.class);
    //protected static Configuration config = Configuration.getInstance();
    protected static Browser browser = new Browser();
    public static Boolean isTestinium = false;

    public static final String USERNAME = "selidalk";
    public static final String ACCESS_KEY = "b15114635d227239a56cf3934f10e075";
    public static final String KEY = USERNAME + ":" + ACCESS_KEY;

    public void setUp(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("key", KEY);
        PropertyConfigurator.configure("properties/log4j.properties");
        log.info("Settings Installation Start");
        if (StringUtils.isEmpty(System.getenv("key"))){
            browser.createLocalDriver();
        }
        else {
            try {
                capabilities.setCapability("takesScreenshot", true);
                isTestinium = true;
                setDriver(new RemoteWebDriver(new URL("http://hub.testinium.io/wd/hub"), capabilities));
            } catch (MalformedURLException e) {
                log.error(e.getMessage());
            }

        }

        /**try {
            capabilities.setCapability("takesScreenshot", true);
            capabilities.setPlatform(Platform.WIN10);
            setDriver(new RemoteWebDriver(new URL("http://hub.testinium.io/wd/hub"), capabilities));
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }**/



   /**     PropertyConfigurator.configure("properties/log4j.properties");
        log.info("Settings Installation Start");
        String KEY = "selidalk:b15114635d227239a56cf3934f10e075";
        if(StringUtils.isEmpty(System.getenv("key"))){
            browser.createLocalDriver();
        }
        else{
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("key", KEY);

                capabilities.setCapability(CapabilityType.PLATFORM, "WIN10");
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                capabilities.setCapability(CapabilityType.VERSION, "LATEST");
                capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
                capabilities.setCapability("recordsVideo", true);
                capabilities.setCapability("screenResolution", "SXGA");
                setDriver(new RemoteWebDriver(new URL("http://hub.testinium.io/wd/hub"), capabilities));

            } catch (MalformedURLException e) {
                log.error(e.getMessage());
            }
        } **/
    }


    public static  void setDriver(RemoteWebDriver driver){
        BaseTest.driver = driver;
    }

    public static RemoteWebDriver getDriver( ){
        return  driver;

    }
    public  static void tearDown(){
        //getDriver().quit();
    }
}
