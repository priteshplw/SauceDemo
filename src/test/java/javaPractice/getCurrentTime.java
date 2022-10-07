package javaPractice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class getCurrentTime {
    public static void main(String[] args) {
        //System date and time
        System.out.format("\nCurrent Date time: %tc%n\n", System.currentTimeMillis());

        //Date in specific format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        sdf.setCalendar(Calendar.getInstance(TimeZone.getTimeZone("GMT")));

        System.out.println("\nNow: "+sdf.format(System.currentTimeMillis()));
    }
}
