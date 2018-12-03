package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
