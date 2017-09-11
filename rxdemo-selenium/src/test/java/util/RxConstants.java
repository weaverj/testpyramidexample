package util;

public class RxConstants {

    public static final String RX_ITEM = "Rx APP";

    //http://localhost:9000/
//    public static final String RX_BASE_URL = "localhost:8090/rxdemo";
    public static final String RX_BASE_URL = "localhost:9000";

    public static final String SELENIUM_SERVER_FOR_L_CHROME = "localhost";

    public static final String H1_TITLE_RX_DEMO = "/html/body/div/h1";
    public static final String H1_TITLE_RX_DEMO_TEXT = "Rx Demo";

    //"Medication"
    public static final String LABEL_MEDICATION = "/html/body/form/fieldset[1]/div/label";
    public static final String LABEL_MEDICATION_TEXT = "Medication";

    public static final String SELECT_DRUG_MEDICATION = "medication";
    public static final String SELECT_DRUG_MEDICATION_DIAZEPAM = "diazepam";
    public static final String INPUT_DRUG_MEDICATION_DOSE_AMOUNT = "dose-amount";
    //public static final String INPUT_DRUG_MEDICATION_DOSE_AMOUNT_10 = "10";
    public static final String INPUT_DRUG_MEDICATION_DOSE_UNIT = "dose-unit";
    public static final String INPUT_DRUG_MEDICATION_DOSE_UNIT_TABLET = "tablet";
    public static final String INPUT_DRUG_MEDICATION_ROUTE = "route";
    public static final String INPUT_DRUG_MEDICATION_ROUTE_ORAL = "Oral";
    public static final String INPUT_DRUG_MEDICATION_DURATION = "duration";
    public static final String INPUT_DRUG_MEDICATION_DURATION_29_DAYS = "29 days";
    public static final String INPUT_DRUG_MEDICATION_DURATION_31_DAYS = "31 days";
    public static final String INPUT_DRUG_MEDICATION_FREQUENCY = "frequency";
    public static final String INPUT_DRUG_MEDICATION_FREQUENCY_ONCE_DAILY = "once per day";

    public static final String SUCCESS_MESSAGE = "//*[@id=\'successMessages\']";
    public static final String PROHIBITED_MESSAGE = "//*[@id=\'errorMessages\']";
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

    public static final String SUCCESSFUL_PRESCRIPTION = "Prescription successfully transmitted.";


}
