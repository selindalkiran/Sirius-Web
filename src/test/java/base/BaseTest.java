package base;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Browser;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public static RemoteWebDriver driver;
    private String methodName = null;
    protected static final Logger log = Logger.getLogger(BaseTest.class);
    //protected static Configuration config = Configuration.getInstance();
    protected static Browser browser = new Browser();

    public void setUp(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        PropertyConfigurator.configure("properties/log4j.properties");
        log.info("Settings Installation Start");

        String key = "demirelahmet:bba815c75f0c90da38b258e1df762c06";

        if(StringUtils.isEmpty(System.getenv("key"))){
            browser.createLocalDriver();
        }
        else{
            capabilities.setCapability("key", key);
            try {
                setDriver(new RemoteWebDriver(new URL("http://hub.testinium.io/wd/hub"), capabilities));
            } catch (MalformedURLException e) {
                log.error(e.getMessage());
            }
        }
    }


    public static  void setDriver(RemoteWebDriver driver){
        BaseTest.driver = driver;
    }

    public static RemoteWebDriver getDriver( ){
        return  driver;

    }
    public  static void tearDown(){
        getDriver().quit();
    }
}
