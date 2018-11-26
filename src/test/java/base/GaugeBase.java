package base;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class GaugeBase extends BasePage{
    public GaugeBase(WebDriver driver) {
        super(driver);
    }

    public void navigateSite(String url) {
        navigateTo(url);
    }



    public void Click(By by) {
        waitAllRequest();
        clickElementJS(by);
    }

    public void SendKeys(By by, String text) {
        sendKeys(by, text);
    }

    public String captureScreen() {
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "./screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }


    /**
     * Until Element Appear Method
     */
    public void untilElementAppear(By by) {
        untilElementAppear(by);
    }

    public void clickJS(By by, int... index) {
        getJSExecutor().executeScript("arguments[0].click();", findElement(by, index));
    }

    public void waitAllRequest(){
        wa.ajaxComplete();
        wa.pageLoadComplete();
        waitSeconds(3);
    }

}
