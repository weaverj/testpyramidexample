package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;



/**
 * Created by cindyleffler on 6/6/17.
 */
public class WaitForObjects {
    public static void waitUntilxpath (WebDriver inDriver, String inID) {
        WebElement myElement = (new WebDriverWait(inDriver, 20))
                .until( presenceOfElementLocated( By.xpath(inID)));
    }


}
