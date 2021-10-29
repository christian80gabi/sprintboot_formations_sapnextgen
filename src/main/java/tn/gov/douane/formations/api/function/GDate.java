package tn.gov.douane.formations.api.function;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GDate {

    public static Timestamp precisionDateTime = getPrecisionDateTime();
    public static Date precisionDate = getPrecisionDate();

    private static Timestamp getPrecisionDateTime(){
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
        Timestamp time = Timestamp.valueOf(sdf.format(date));

        return time;
    }

    private static Date getPrecisionDate(){
        Date date = new Date();
        return date;
    }
}
