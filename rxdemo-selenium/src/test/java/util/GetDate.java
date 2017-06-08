package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cindyleffler on 6/6/17.
 */
public class GetDate {
    public static String getSimpleFormatCurrentDate()
    {
        SimpleDateFormat gmtDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String jsDate = gmtDateFormat.format(new Date());
        System.out.println("Current Date: " + jsDate);
        return jsDate;
    }
}
