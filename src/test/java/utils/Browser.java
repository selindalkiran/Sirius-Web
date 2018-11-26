package utils;

import base.BaseTest;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Browser {

    public static final String URL = "http://hub.testinium.io/wd/hub";
    private DesiredCapabilities capabilities;

    public void setBrowser(String browserName, String browserVersion, String url, int implicitlyWait)
            throws MalformedURLException {
        URL hub = new URL(URL);
        String key = null;

        if(StringUtils.isNotEmpty(key)){
            ChromeOptions options = new ChromeOptions();
            capabilities = DesiredCapabilities.chrome();
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-translate");
            options.addArguments("start-maximized");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability("key",key);
            BaseTest.setDriver(new RemoteWebDriver(hub, capabilities));
        }
        else if(StringUtils.isNotEmpty(key) && browserName != null){
            ChromeOptions options = new ChromeOptions();
            capabilities = DesiredCapabilities.chrome();
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-translate");
            options.addArguments("start-maximized");
            capabilities.setCapability(ChromeOptions.CAPABILITY,options);
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.getCurrent());

            selectPath(capabilities.getPlatform());
            createLocalDriver();

            BaseTest.getDriver().manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
            BaseTest.getDriver().manage().window().maximize();
        }
    }
    public void createLocalDriver(){
        ChromeOptions options = new ChromeOptions();
        capabilities = DesiredCapabilities.chrome();
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-translate");
        //				options.addArguments("--kiosk");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.getCurrent());
        selectPath(capabilities.getPlatform());

        BaseTest.setDriver(new ChromeDriver(capabilities));
        BaseTest.getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);




        /**
         capabilities = DesiredCapabilities.firefox();
         capabilities.setBrowserName("firefox");
         capabilities.setPlatform(Platform.getCurrent());
         selectPath(capabilities.getPlatform());
         BaseTest.setDriver(new FirefoxDriver(capabilities));
         BaseTest.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

         **/
    }
    public void selectPath(Platform platform){
        String browser;
        if ("chrome".equalsIgnoreCase(capabilities.getBrowserName())) {
            browser = "webdriver.chrome.driver";
            switch (platform) {
                case MAC:
                    System.setProperty(browser, "properties/driver/chromedriver");
                    break;
                case WIN10:
                case WIN8:
                case WIN8_1:
                case WINDOWS:
                    System.setProperty(browser, "properties/driver/chromedriverwin.exe");
                    break;

                default:
                    //log.info("PLATFORM DOES NOT EXISTS");
                    break;
            }
        }else if("FIREFOX".equalsIgnoreCase(capabilities.getBrowserName())){
            browser = "webdriver.gecko.driver";
            switch (platform) {
                case MAC:
                    System.setProperty(browser, "properties/driver/geckodrivermac");
                    break;
                case WIN10:
                case WIN8:
                case WIN8_1:
                case WINDOWS:
                    System.setProperty(browser, "properties/driver/geckodriverwin.exe");
                    break;

                default:
                    // log.info("PLATFORM DOES NOT EXISTS");
                    break;
            }
        }
    }
}
