package test;

import base.BaseTest;
import base.GaugeBase;

import com.thoughtworks.gauge.*;
import mapping.MapMethodType;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import util.ContextPage;

import java.util.Date;

import static base.BaseTest.getDriver;
import static base.BaseTest.setUp;
import static base.BaseTest.tearDown;

import static mapping.Mapper.foundActivity;

public class StepImplementation extends BaseTest {
    GaugeBase base;

    @BeforeScenario
    public void before(){
        PropertyConfigurator.configure("properties/log4j.properties");
        setUp();
        base = new GaugeBase(getDriver());
        driver.manage().window().getSize();
    }

    @AfterScenario
    public void afterMethod() {
        tearDown();
    }

    @AfterStep
    public void screenShots(ExecutionContext context){
        String specFileName = context.getCurrentScenario().getName();
        String  title = driver.getTitle();

        try {
            Thread.sleep(10);
            base.takeScreenShot(specFileName, title);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Step("<url> adresine gidilir")
    public void navigateToLifebox( String url ) {
        base.navigateSite(url);
    }

    @Step("<button> butonuna tıklanır")
    public  void  clickButton(String button) {
        base.Click( foundActivity( MapMethodType.CLICK_ELEMENT, button ) );
    }
    @Step("<by> elementinden gelen text <text> değerini içerir")
    public void getTextContains(String by, String text) {
        String str = driver.findElement(foundActivity(MapMethodType.IS_ELEMENT, by)).getText();
        Assert.assertFalse(by+" alanı boş geldi",StringUtils.isEmpty(str));
        Assert.assertTrue(by+" alanından gelen değer "+text+" değerini içermiyor",str.contains(text));
    }


    @Step("<by> alanına <text> metni yazılır")
    public  void  inputText(String by, String text) {
        log.info( text );
        base.SendKeys( foundActivity( MapMethodType.INPUT_ELEMENT,by),text);
    }

    @Step("<by> elementi kontrol et")
    public void check(String by) {
        ContextPage.isPage(foundActivity(MapMethodType.IS_ELEMENT, by));
    }

    @Step("<by> elementinin aktif olmadığını kontrol et")
    public void checkButtonDisable(String by) {
        ContextPage.isButtonDisabled(foundActivity(MapMethodType.IS_ELEMENT, by));
    }

    @Step("<by> elementinin aktif olduğunu kontrol et")
    public void checkButtonEnable(String by) {
        ContextPage.isButtonEnabled(foundActivity(MapMethodType.IS_ELEMENT, by));
    }

    @Step("<by> listesinden <text> değerini seç")
    public void selectFromList(String by, String text) {
        ContextPage.selectFromList(foundActivity(MapMethodType.SELECT_OPTION, by), text);
    }

    @Step("<seconds> saniye bekle$")
    public void waitSeconds(int seconds) {
        ContextPage.wait(seconds);
    }


}