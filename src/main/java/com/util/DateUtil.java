package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
    public static String getTodayDate(String format){
        DateFormat dateFormat=new SimpleDateFormat(format);
        return dateFormat.format(Calendar.getInstance().getTime());
    }
}
