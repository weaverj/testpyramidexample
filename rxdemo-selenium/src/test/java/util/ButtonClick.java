package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

/**
 * Created by cindyleffler on 6/7/17.
 */
public class ButtonClick {
    public static void buttonClickByXpath(WebDriver inDriver, String inButtonID, String inButtonValue)
    {

        WebElement
                searchElement = inDriver.findElement(By.xpath(inButtonID));
        String jsTag = searchElement.getTagName();
        String jsValue = searchElement.getText().replaceAll("\\s+$", "");
        assertEquals(inButtonValue, jsValue);
        searchElement.click();
        System.out.println(jsTag + " '" + jsValue + "'" + " was Clicked!");
    }
}
