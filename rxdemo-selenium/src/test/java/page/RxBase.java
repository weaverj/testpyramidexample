package page;

import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.RxConstants;
import util.SetupRx;
import util.StartBrowserSelections;

import java.net.URL;
import java.util.Collection;

public class RxBase {

    private static final String URL1 = "http://"
            + RxConstants.RX_BASE_URL;
    private static final String URL2 = "";

    private String mBrowserName;
    private String mItemName;
    protected DesiredCapabilities mDC;
    protected String mAddress;
    protected WebDriver mDriver;

    public RxBase(String inBrowserName, String inAddress, DesiredCapabilities inDC, String inItemName) {
        mBrowserName = inBrowserName;
        mDC = inDC;
        mAddress = inAddress;
        mItemName = inItemName;
    }

    public WebDriver getMDriver() {
        return mDriver;
    }

    public void setMDriver(WebDriver mDriver) {
        this.mDriver = mDriver;
    }

    public DesiredCapabilities getMDC() {
        return mDC;
    }
    public void setMDC(DesiredCapabilities mDC) {
        this.mDC = mDC;
    }
    public String getMAddress() {
        return mAddress;
    }
    public void setMAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> browserId() {
        return StartBrowserSelections
                .startALocalBrowser(RxConstants.RX_ITEM);
    }

    @Before
    public void setUp() throws Exception {
        mDriver = new RemoteWebDriver(new URL("http://" + mAddress
                + ":4444/wd/hub"), mDC);
        SetupRx.setupRx(mDriver,
                getEnvironmentUrl(), URL2,
                mBrowserName, mItemName);
    }

    private String getEnvironmentUrl() {
        String envUrl = System.getenv("RXDEMO_CLIENT_URL");
        if ((envUrl == null) || ("".equals(envUrl))) {
           return URL1;
        }
        return envUrl;
    }

    @After
    public void tearDown() throws Exception {
        mDriver.quit();
    }
}
