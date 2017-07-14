package page;

import org.openqa.selenium.WebDriver;
import util.ButtonClick;
import util.RxConstants;
import util.WaitForObjects;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

/**
 * Created by cindyleffler on 7/14/17.
 */
public class EnterPrescriptionCommand
{
    private String doseamount;
    private String doseunit;

    public EnterPrescriptionCommand(String doseamount)
    {
        this.doseamount = doseamount;
    }

    public EnterPrescriptionCommand WithDoseUnit(String doseunit)
    {
        this.doseunit = doseunit;
        return this;
    }

    public void AddRxtoCart(WebDriver mDriver)
    {
        mDriver.findElement(id( RxConstants.INPUT_DRUG_MEDICATION_DOSE_AMOUNT)).sendKeys(doseamount);;
        mDriver.findElement(id(RxConstants.INPUT_DRUG_MEDICATION_DOSE_UNIT)).sendKeys(doseunit);
        WaitForObjects.waitUntilxpath(mDriver, RxConstants.BTN_RX_ADD_RX_TO_CART);
        ButtonClick.buttonClickByXpath(mDriver,
                RxConstants.BTN_RX_ADD_RX_TO_CART,
                RxConstants.BTN_RX_ADD_RX_TO_CART_TEXT);
    }

}