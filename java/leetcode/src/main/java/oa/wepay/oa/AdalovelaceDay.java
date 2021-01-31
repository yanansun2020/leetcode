package oa.wepay.oa;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class AdalovelaceDay {
    public int getSecondSundayOfMarch (int year) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
//        cal.setFirstDayOfWeek(Calendar.TUESDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        cal.set(Calendar.WEEK_OF_MONTH,2);
        return cal.get(Calendar.DAY_OF_MONTH);
//        return cal.getTime();
    }
    @Test
    public void test(){

        int date = getSecondSundayOfMarch(2019);
    }
}
