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

@RunWith(Parameterized.class)
public class RxChooseMedicationAlerts extends RxBase {
    public RxChooseMedicationAlerts(String inBrowserName, String inAddress, DesiredCapabilities inDC, String inItemName) {
        super( inBrowserName, inAddress, inDC, inItemName );
    }

    @Test
    public void exChooseMedicationAlerts()
            throws Exception {

        String jsDate = GetDate.getSimpleFormatCurrentDate();
        Assert.assertTrue(RxConstants.MESSAGE_FAILED_TO_LAUNCH ,
                RxMedicationPage.isAt(mDriver));
        RxMedicationPage.verifyButtonsIsEnabled(mDriver);
    }
}
