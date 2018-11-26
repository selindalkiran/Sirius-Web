package test;

import base.BaseTest;
import base.GaugeBase;
import com.thoughtworks.gauge.*;
import mapping.MapMethodType;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;

import static mapping.Mapper.foundActivity;
import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest {

    GaugeBase base;

    @BeforeScenario
    public void before(){
        PropertyConfigurator.configure("properties/log4j.properties");
        setUp();

        base = new GaugeBase(getDriver());
    }

    @AfterScenario
    public void afterMethod() {
        tearDown();
    }



    @Step("<url> url sayfasina gidilir")
    public void getUrl(String url){
        base.navigateSite(url);
    }

    @Step("<by> alanına <text> metni yazılır")
    public  void  inputText(String by, String text) {
        //base.Click( foundActivity( MapMethodType.INPUT_ELEMENT,by));
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(foundActivity( MapMethodType.INPUT_ELEMENT,by)));
        base.SendKeys( foundActivity( MapMethodType.INPUT_ELEMENT,by),text);
    }

}
