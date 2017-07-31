package rxdemo;

import org.junit.Assert;
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

        Assert.assertTrue(RxConstants.MESSAGE_FAILED_TO_LAUNCH ,
                RxMedicationPage.isAt(mDriver));
        RxMedicationPage.verifyButtonsIsEnabled(mDriver);

        SelectionOptions.dropdownSelectionValue(mDriver,
                RxConstants.SELECT_DRUG_MEDICATION,
                RxConstants.SELECT_DRUG_MEDICATION_DIAZEPAM);
        RxMedicationPage.AddRxAs()
                .WithDoseAmount(10)
                .WithDoseUnit(RxConstants.INPUT_DRUG_MEDICATION_DOSE_UNIT_TABLET)
                .WithRoute(RxConstants.INPUT_DRUG_MEDICATION_ROUTE_ORAL)
                .WithFrequency(RxConstants.INPUT_DRUG_MEDICATION_FREQUENCY_ONCE_DAILY)
                .WithDuration(RxConstants.INPUT_DRUG_MEDICATION_DURATION_31_DAYS)
                .AddRxtoCart(mDriver);

        Assert.assertTrue(RxMedicationPage.showProhibitedMessage(mDriver));
    }
}