package string;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class NumberofDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate day1 = LocalDate.parse(date1);
        LocalDate day2 = LocalDate.parse(date2);
        return (int)Math.abs(DAYS.between(day1, day2));
    }
    public int daysBetweenDates_not_work(String date1, String date2) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date_1 = df.parse(date1);
            Date date_2 = df.parse(date2);
            long timeStamp1 = date_1.getTime()/1000;
            long timeStamp2 = date_2.getTime()/1000;
            long range = Math.abs(timeStamp2 - timeStamp1);
            long result = range/(24*60*60);
            return (int)result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
    public static void main(String[] args) {
        NumberofDaysBetweenTwoDates test = new NumberofDaysBetweenTwoDates();
        int result0 = test.daysBetweenDates("2074-09-12", "1983-01-08");
        System.out.println(result0);
        int result = test.daysBetweenDates("2019-06-29", "2019-06-30");
        System.out.println(result);
        int result1 = test.daysBetweenDates("2020-01-15", "2019-12-31");
        System.out.println(result1);


    }
}