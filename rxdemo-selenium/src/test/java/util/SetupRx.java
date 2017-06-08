package util;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SetupRx
{

    public static void setupRx(WebDriver inDriver,
                                     String inURL1, String inURL2, String inBrowserName, String inItemName)
    {
        inDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inDriver.get(inURL1 + inURL2);
        WaitForObjects.waitUntilxpath(inDriver, RxConstants.H1_TITLE_RX_DEMO);
        System.out.println(inBrowserName + " - " + inItemName);
    }
}
