package page;

import org.openqa.selenium.WebDriver;
import util.ButtonClick;
import util.RxConstants;
import util.WaitForObjects;

import static org.openqa.selenium.By.id;

/**
 * Created by cindyleffler on 7/14/17.
 */
public class EnterPrescriptionCommand
{
    private int doseamount;
    private String doseunit;
    private String route;
    private String frequency;
    private String duration;

    public EnterPrescriptionCommand()
    {

    }

    public EnterPrescriptionCommand WithDoseAmount(int doseamount) {
        this.doseamount = doseamount;
        return this;
    }

    public EnterPrescriptionCommand WithDoseUnit(String doseunit)
    {
        this.doseunit = doseunit;
        return this;
    }

    public EnterPrescriptionCommand WithRoute(String route) {
        this.route = route;
        return this;
    }

    public EnterPrescriptionCommand WithFrequency(String frequency) {
        this.frequency = frequency;
        return this;
    }

    public EnterPrescriptionCommand WithDuration(String duration) {
        this.duration = duration;
        return this;
    }

    //TODO - submit new fields.
    public void AddRxtoCart(WebDriver mDriver)
    {
        mDriver.findElement(id( RxConstants.INPUT_DRUG_MEDICATION_DOSE_AMOUNT)).sendKeys(String.valueOf(doseamount));;
        mDriver.findElement(id(RxConstants.INPUT_DRUG_MEDICATION_DOSE_UNIT)).sendKeys(doseunit);
        mDriver.findElement(id(RxConstants.INPUT_DRUG_MEDICATION_ROUTE)).sendKeys(route);
        mDriver.findElement(id(RxConstants.INPUT_DRUG_MEDICATION_FREQUENCY)).sendKeys(frequency);
        mDriver.findElement(id(RxConstants.INPUT_DRUG_MEDICATION_DURATION)).sendKeys(duration);
        WaitForObjects.waitUntilxpath(mDriver, RxConstants.BTN_RX_ADD_RX_TO_CART);
        ButtonClick.buttonClickByXpath(mDriver,
                RxConstants.BTN_RX_ADD_RX_TO_CART,
                RxConstants.BTN_RX_ADD_RX_TO_CART_TEXT);
    }


}