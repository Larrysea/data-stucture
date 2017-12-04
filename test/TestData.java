package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Larry-sea on 2017/10/21.
 */
public class TestData {


    public static void main(String[] args) {
        long dataStamp1 = 1508428800000l;
        long dataStamp2 = 1508515200000l;

        int days = (int) ((dataStamp2 - dataStamp1) / (1000 * 3600 * 24));
        try {
            System.out.println(days);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static long getDistanceDays(String str1, String str2) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date one;
        Date two;
        long days = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

}
