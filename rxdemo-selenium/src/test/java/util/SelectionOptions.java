package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by cindyleffler on 7/14/17.
 */
public class SelectionOptions {
    public static void dropdownSelectionValue(WebDriver inDriver, String inWebListID, String inValue) {
        WebElement dropdownList = inDriver.findElement( By.id( inWebListID ) );
        List<WebElement> options = dropdownList.findElements( By.tagName( "option" ) );
        for (int i = 0; i < options.size(); i++) {
            if (options.get( i ).getText().equals( inValue )) {
                options.get( i ).click();
            }
        }
        String selectedOption = "";
        for ( WebElement option:options) {
            if (option.isSelected()) selectedOption = option.getText();
        }
        assertThat( selectedOption, is( inValue ) );
        System.out.println( selectedOption +  " was Selected!" );
    }
}
