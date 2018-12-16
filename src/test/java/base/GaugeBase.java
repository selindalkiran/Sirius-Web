package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by olcayekin on 16/06/2017.
 */
public class GaugeBase extends BasePage{
    public GaugeBase( WebDriver driver ) {
        super(driver);
    }

    /**
     * Click Element Method
     */
    public void Click(By by) {

        clickElement(by);
    }

    /**
     * Fill Input Method
     *
     */
    public void SendKeys(By by, String text) {
        sendKeys(by, text);
    }

    /**
     * Time Unit
     *
     * @param sleepTime
     */
    public void timeUnitSeconds(int sleepTime){
        waitSeconds(sleepTime);
    }

    /**
     * Navigate to Page
     *
     * @param url
     */
    public void navigateSite(String url) {
        navigateTo(url);
    }

    /**
     * @param string
     * @return
     */
    public String converTurkishCharacter(String string) {
        return convertTurkishChar(string).toUpperCase(new Locale("en"));
    }

    /**
     * Until Element Appear Method
     *
     */
    public void untilElementAppear(By by) {
        untilElementAppear(by);
    }

    public void clickJS(By by, int... index){
        getJSExecutor().executeScript("arguments[0].click();", findElement(by, index));
    }


    public String takeScreenShot(String specFileName, String title){
        String path;
        System.out.println("------------Ahmetttt-------------");
        Date date = new Date();
        String localDate = date.toString();
        System.out.println(localDate );
        try {
            WebDriver augmentDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)augmentDriver).getScreenshotAs(OutputType.FILE);
            path = "./screenshots/" + specFileName + "/"  + title+ ".png";
            FileUtils.copyFile(source, new File(path));
        }
        catch(Exception e){
            path = "Failed to capture screenshot" + e.getMessage();
        }
        return  path;

    }
}
