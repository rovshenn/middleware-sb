package api.rov.middleware.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date createDateString(String dateStr) {
        Date date = null;
        if(dateStr != null) {
            try {
                date = DATE_FORMAT.parse(dateStr);
            } catch (ParseException e) { }
        }
        return date == null ? new Date() : date;
    }
}
