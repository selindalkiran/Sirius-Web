package base;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.util.Random;

/**
 * Created by olcayekin on 16/06/2017.
 */
public class BasePage extends BasePageUtil {
    public BasePage( WebDriver driver ) {
        super(driver);
    }
    /**
     * Desired length random string
     *
     * @param size
     * @return
     */
    protected String createRandomString(int size) {
        return RandomStringUtils.randomAlphanumeric(size);
    }

    /**
     * The desirable range random int
     *
     * @param start
     * @param end
     * @return
     */
    protected int createRandomInteger(int start, int end) {
        int randomNumber;
        if (start > end) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        } else {
            Random random = new Random();
            randomNumber = random.nextInt((end - start) + 1) + start;
        }
        return randomNumber;
    }

    /**
     * The remove in text of number
     *
     * @param regexText
     * @return
     */
    protected String regexString(String regexText) {
        return regexText.replaceAll("\\d", "");
    }

    /**
     * Convert to month
     *
     * @param month
     * @return
     */
    protected String convertToMonth(String month) {
        String[] monthList = { "Month", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos",
                "Eylül", "Ekim", "Kasım", "Aralık" };
        if (month.length() > 2) {
            for (String selectedMonth : monthList) {
                if (selectedMonth.equals(month)) {
                    return month;
                }
            }
        } else if (month.length() == 1 || month.length() == 2) {
            return monthList[Integer.parseInt(month)];
        }
        return "Does Not Exists Data Date";
    }

}
