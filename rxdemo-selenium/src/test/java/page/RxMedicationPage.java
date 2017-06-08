package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ButtonClick;
import util.RxConstants;
import util.VerifyButton;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class RxMedicationPage {

    public static boolean isButtonEnabled(WebDriver mDriver) {
        return mDriver.findElement(xpath(RxConstants.BTN_RX_ADD_RX_TO_CART)).isEnabled();
    }

    public static boolean isAt(WebDriver mDriver) {
        List<WebElement> we = mDriver.findElements(xpath(RxConstants.H1_TITLE_RX_DEMO));
        if (we.size() > 0) {
            for (int i = 0; i < we.size(); i++)
            {
                System.out.println(we.get(i).getTagName() + ": '" + we.get(i).getText() + " was Verified!");
            }

            return (we.get(0).getText().equals(RxConstants.H1_TITLE_RX_DEMO_TEXT) ||
                    (we.get(0).isEnabled()));
        }
        return false;
    }

    public static void verifyButtonsIsEnabled(WebDriver mDriver) {
        VerifyButton.verifyButtonTextEnabledDisplayedByXpath(mDriver,
                RxConstants.BTN_RX_ADD_RX_TO_CART,
                RxConstants.BTN_RX_ADD_RX_TO_CART_TEXT,
                true, true);
        VerifyButton.verifyButtonTextEnabledDisplayedByXpath(mDriver,
                RxConstants.BTN_CANCEL,
                RxConstants.BTN_CANCEL_TEXT,
                true, true);
    }

    public static void clickAddButton(WebDriver mDriver){
        ButtonClick.buttonClickByXpath(mDriver,
                RxConstants.BTN_RX_ADD_RX_TO_CART,
                RxConstants.BTN_RX_ADD_RX_TO_CART_TEXT);
    }
}
