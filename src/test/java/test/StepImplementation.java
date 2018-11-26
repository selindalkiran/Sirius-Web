package test;

import base.BaseTest;
import base.GaugeBase;
import com.thoughtworks.gauge.*;
import mapping.MapMethodType;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.List;

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
        base.captureScreen();
    }

    @Step("<button> butonuna tıklanır")
    public  void  clickButton(String button) {
        WebElement element = driver.findElement(foundActivity(MapMethodType.CLICK_ELEMENT, button));
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        driver.executeScript(scrollElementIntoMiddle,element);
        base.Click( foundActivity( MapMethodType.CLICK_ELEMENT, button ) );
        base.captureScreen();
    }

    @Step("<by> alanına <text> metni yazılır")
    public  void  inputText(String by, String text) {
        //base.Click( foundActivity( MapMethodType.INPUT_ELEMENT,by));
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(foundActivity( MapMethodType.INPUT_ELEMENT,by)));
        base.SendKeys( foundActivity( MapMethodType.INPUT_ELEMENT,by),text);
        base.captureScreen();
    }


    @Step("<by> elementin doluluğu kontrol edilir")
    public void getElementText(String by) {
        String str = driver.findElement(foundActivity(MapMethodType.IS_ELEMENT, by)).getText();
        Assert.assertFalse(by+" alanı boş geldi",StringUtils.isEmpty(str));
    }

    @Step("<by> elementinden gelen text <text> değerini içerir")
    public void getTextContains(String by, String text) {
        String str = driver.findElement(foundActivity(MapMethodType.IS_ELEMENT, by)).getText();
        Assert.assertFalse(by+" alanı boş geldi",StringUtils.isEmpty(str));
        Assert.assertTrue(by+" alanından gelen değer "+text+" değerini içermiyor",str.contains(text));
    }


    @Step("<by> elementinin görülmesi beklenir")
    public void untilElementAppear(String by) {
        WebDriverWait wait = new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.presenceOfElementLocated(foundActivity(MapMethodType.IS_ELEMENT, by)));
        //base.untilElementAppear(foundActivity(MapMethodType.IS_ELEMENT, by));
    }

    @Step("<by> elementinin görülmemesi beklenir")
    public void untilElementNonAppear(String by) {
        WebDriverWait wait = new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(foundActivity(MapMethodType.IS_ELEMENT, by)));
        //base.untilElementAppear(foundActivity(MapMethodType.IS_ELEMENT, by));
    }



    @Step("<by> listesinden <i> numaralı elementi seç")
    public void selectNthElement(String by, int i) {
        List<WebElement> element = driver.findElements(foundActivity(MapMethodType.SELECT_OPTION, by));
        element.get(i-1).click();
        //ContextPage.selectFromList(foundActivity(MapMethodType.SELECT_OPTION, by), text);
    }


    @Step("<by> dropdown'undan <text> elementini seç")
    public void selectFromDropdown(String by, String text) {

        WebElement element = driver.findElement(foundActivity(MapMethodType.SELECT_OPTION, by));
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        driver.executeScript(scrollElementIntoMiddle,element);
        Select selectElement = new Select(driver.findElement(foundActivity(MapMethodType.SELECT_OPTION, by)));
        selectElement.selectByVisibleText(text);
        base.waitAllRequest();
        //ContextPage.selectFromList(foundActivity(MapMethodType.SELECT_OPTION, by), text);
    }


    @Step("<by> tarih alanından <text> gününü seç")
    public void selectDate(String by, String text) {
        base.Click(foundActivity(MapMethodType.SELECT_OPTION, by));
        List<WebElement> dateList = driver.findElements(By.cssSelector(".datepicker-body > div > a"));
        for (WebElement date:
                dateList) {
            if(date.getText().equals(text)){
                date.click();
                break;
            }
        }
    }

}
