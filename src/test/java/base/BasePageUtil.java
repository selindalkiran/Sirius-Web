package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.fail;

public class BasePageUtil {
    protected WebDriver driver;
    protected WebDriverWait wait;
   // protected WaitingActions wa;
    protected final Logger log = Logger.getLogger(getClass());

    public BasePageUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);

    }
    protected void navigateTo(String url) {
        driver.navigate().to(url);
    }

    protected void sendKeys(By by, String text, int... index) {
        sendKeys(by, text, false, index);
    }

    /**
     * Provide data input(By by, String text, int index) press enter
     *
     * @param by
     * @param text
     * @param pressEnter
     * @param index
     */
    protected void sendKeys(By by, String text, boolean pressEnter, int... index) {
        WebElement element = null;
        try {
            element = findElement(by,index);

        } catch (Exception e) {
            log.error("ERROR :", e);
            assertFail("Element Not Found :" + e.getMessage());
        }
        if (element == null) {
            nullElementException(by, index);
        } else if (element.isDisplayed()) {

            log.info("Element Send Keys : " + text + "-" + element);
            element.clear();
            element.sendKeys(text);
            element.sendKeys(Keys.TAB);
            if (pressEnter) {
                element.sendKeys(Keys.ENTER);
            }
        }
    }

    protected void assertFail(String message) {
        fail(message);
    }

    protected void nullElementException(By by, int... index) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ELEMENT (");
        stringBuilder.append(by);
        stringBuilder.append(",");
        stringBuilder.append(index.length > 0 ? index[0] : "");
        stringBuilder.append(") NOT EXISTS; AUTOMATION DATAS MAY BE INVALID!");
        throw new NullPointerException(stringBuilder.toString());
    }

    protected WebElement findElement( By by, int... index) {
        //waitAllRequest();
        if (index.length == 0) {
            // highlightElement(element);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (index[0] >= 0) {
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            if (!elements.isEmpty() && index[0] <= elements.size()) {
                return elements.get(index[0]);
            }
        }
        return null;
    }

}
