package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

/**
 * Created by cindyleffler on 6/6/17.
 */
public class VerifyButton {
    public static void verifyButtonTextEnabledDisplayedByXpath(WebDriver inDriver, String inButtonID,
                                                               String inButtonValue, Boolean inEnabled, Boolean inDisplayed)
    {

        WebElement searchElement = inDriver.findElement(By.xpath(inButtonID));
        String jsTag = searchElement.getTagName();
        String jsText = searchElement.getText().replace("  ", " ");
        Boolean bEnabled = searchElement.isEnabled();
        Boolean bDisplayed = searchElement.isDisplayed();
        assertEquals(inButtonValue, jsText);
        assertEquals(inEnabled, bEnabled);
        assertEquals(inDisplayed, bDisplayed);
        System.out.println(jsTag + " '" + jsText + "' Enabled  - '" + bEnabled + "'; Displayed - '"
                + bDisplayed + "'; were Verified!");
    }
}
