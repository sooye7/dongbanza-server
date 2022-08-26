package com.spring.companion.service.ocr;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getDateTime() {
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HHmmss");
        String now = dayTime.format(new Date(time));
        return now;
    }
    public static String getTime() {
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("24hhmmss");
        String now = dayTime.format(new Date(time));
        return now;
    }

}
