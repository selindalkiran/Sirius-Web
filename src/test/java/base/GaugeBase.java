package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GaugeBase extends BasePage{
    public GaugeBase(WebDriver driver) {
        super(driver);
    }

    public void navigateSite(String url) {
        navigateTo(url);
    }

    public void click(By by){

    }





}
