package rxdemo;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.RxBase;
import page.RxMedicationPage;
import util.GetDate;
import util.RxConstants;
import util.SelectionOptions;

@RunWith(Parameterized.class)
public class OpiateOver30NotAllowedTest extends RxBase {
    public OpiateOver30NotAllowedTest(String inBrowserName, String inAddress, DesiredCapabilities inDC, String inItemName) {
        super( inBrowserName, inAddress, inDC, inItemName );
    }

    @Test
    public void opiateOver30NotAllowedTest()
            throws Exception {

        String jsDate = GetDate.getSimpleFormatCurrentDate();
        Assert.assertTrue(RxConstants.MESSAGE_FAILED_TO_LAUNCH ,
                RxMedicationPage.isAt(mDriver));
        RxMedicationPage.verifyButtonsIsEnabled(mDriver);

        SelectionOptions.dropdownSelectionValue(mDriver,
                RxConstants.SELECT_DRUG_MEDICATION,
                RxConstants.SELECT_DRUG_MEDICATION_DIAZEPAM);
        RxMedicationPage.AddRxAs(RxConstants.INPUT_DRUG_MEDICATION_DOSE_AMOUNT_10)
                .WithDoseUnit(RxConstants.INPUT_DRUG_MEDICATION_DOSE_UNIT_100).AddRxtoCart(mDriver);
    }
}