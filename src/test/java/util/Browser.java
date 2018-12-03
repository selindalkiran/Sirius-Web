package util;

import base.BaseTest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by olcayekin on 16/06/2017.
 */
public class Browser {
    protected final Logger logger = Logger.getLogger(Browser.class);
    private DesiredCapabilities capabilities;

    public void setBrowser( String browserName, String browserVersion, String url, int implicitlyWait )
            throws MalformedURLException {

        String key = "canberk:d772780dcc1834061a37552031e6453d";
        URL hub = new URL("http://hub.testinium.io/wd/hub");
        if (StringUtils.isNotEmpty(key)) {
            logger.info("Testinium ");
            ChromeOptions options = new ChromeOptions();
            capabilities = DesiredCapabilities.chrome();
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-translate");
            options.addArguments("start-maximized");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability("key",key);
        //    BaseTest.setDriver(new RemoteWebDriver(hub, capabilities));
        } else if (StringUtils.isEmpty(key) && browserName != null)
        {
            logger.info("DEFAULT");
            ChromeOptions options = new ChromeOptions();
            capabilities = DesiredCapabilities.chrome();
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-translate");
            options.addArguments("start-maximized");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setBrowserName("chrome");
            capabilities.setVersion(browserVersion);
            capabilities.setPlatform(Platform.getCurrent());

            selectPath(capabilities.getPlatform());
       //     BaseTest.setDriver(new ChromeDriver(capabilities));
            BaseTest.getDriver().manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
            BaseTest.getDriver().manage().window().maximize();
            logger.info("Installation Complete");
            logger.info("********* BROWSER:" + capabilities.getBrowserName() + ", " + "VERSION:" + capabilities.getVersion()
                    + ", " + "PLATFORM:" + capabilities.getPlatform());

        }
    }

    public void createLocalDriver(){
       // setSetUrl("URL");
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
        //BaseTest.getDriver().get("https://google.com");
    }

    public WebDriver getDriver() {
        return BaseTest.getDriver();
    }

    protected void selectPath( Platform platform ) {
        String browser;
        if ("CHROME".equalsIgnoreCase(capabilities.getBrowserName())) {
            browser = "webdriver.chrome.driver";
            switch (platform) {
                case MAC:
                    System.setProperty(browser, "properties/driver/chromedrivermac");
                    break;
                case WIN10:
                case WIN8:
                case WIN8_1:
                case WINDOWS:
                    System.setProperty(browser, "properties/driver/chromedriverwin.exe");
                    break;
                case LINUX:
                    System.setProperty(browser, "properties/driver/chromedriverlinux64.exe");
                    break;
                default:
                    logger.info("PLATFORM DOES NOT EXISTS");
                    break;
            }
        }
    }

}
