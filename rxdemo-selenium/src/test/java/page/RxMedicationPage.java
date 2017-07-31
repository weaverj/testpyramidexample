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
        Boolean we1 = textInElement(mDriver, RxConstants.H1_TITLE_RX_DEMO, RxConstants.H1_TITLE_RX_DEMO_TEXT);
        if (we1 != null) return we1;
        return false;
    }

    private static Boolean textInElement(WebDriver mDriver, String xpath, String expectedText) {
        List<WebElement> we = mDriver.findElements(xpath(xpath));
        if (we.size() > 0) {
            for (int i = 0; i < we.size(); i++)
            {
                System.out.println(we.get(i).getTagName() + ": '" + we.get(i).getText() + " was Verified!");
            }
            return (we.get(0).getText().equals(expectedText) ||
                    (we.get(0).isEnabled()));
        }
        return null;
    }

    public static boolean showsSuccessMessage(WebDriver mDriver) {
        Boolean we1 = textInElement(mDriver, RxConstants.SUCCESS_MESSAGE,
                "Prescription successfully transmitted.");
        if (we1 != null) return we1;
        return false;
    }

    public static boolean showProhibitedMessage(WebDriver mDriver) {
        Boolean we1 = textInElement(mDriver, RxConstants.PROHIBITED_MESSAGE,
                "Prescibing opioids and benzodiazepines in quantities " +
                        "greater than a 30-day supply is prohibited. " +
                        "Refills may be used to extend the intended duration of treatment.");
        if (we1 != null) return we1;
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

    public static EnterPrescriptionCommand AddRxAs()
    {
        return new EnterPrescriptionCommand();
    }

}
