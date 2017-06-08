package util;

public class RxConstants {

    public static final String RX_ITEM = "Rx APP";

    //http://localhost:9000/
    public static final String RX_BASE_URL = "localhost:9000/";

    public static final String SELENIUM_SERVER_FOR_L_CHROME = "10.248.82.161";

    public static final String H1_TITLE_RX_DEMO = "/html/body/div/h1";
    public static final String H1_TITLE_RX_DEMO_TEXT = "Rx Demo";

    //"Medication"
    public static final String LABEL_MEDICATION = "/html/body/form/fieldset[1]/div/label";
    public static final String LABEL_MEDICATION_TEXT = "Medication";

    public static final String BTN_RX_ADD_RX_TO_CART = "/html/body/form/button[1]";
    public static final String BTN_RX_ADD_RX_TO_CART_TEXT = "Add Rx to Cart";
    public static final String BTN_CANCEL = "/html/body/form/button[2]";
    public static final String BTN_CANCEL_TEXT = "Cancel";

    public static final String DIV_TEXT_ERROR_MESSAGE = "//*[@id=\'errorMessages\']/div[1]/text()";
    public static final String DIV_TEXT_ERROR_MESSAGE_TEXT =
            "The following fields are required: Dose Amount, Dose Unit, Frequency, Route, Duration.";

    public static final String DIV_TEXT_ERROR_MESSAGE_2 = "//*[@id=\'errorMessages\']/div[2]/text()";
    public static final String DIV_TEXT_ERROR_MESSAGE_2_TEXT =
            "Prescibing opioids and benzodiazepines in quantities greater than a 30-day supply is prohibited. " +
                    "Refills may be used to extend the intended duration of treatment.";

    public static final String MESSAGE_FAILED_TO_LAUNCH = "Failed to Launch Home Page!";
    public static final String MESSAGE_BUTTONS_UNAVAILABLE = "Buttons are not Available!";

}
