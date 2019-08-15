package com.xunru.utils;

import java.text.SimpleDateFormat;

public class SystemCurrentTimeUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

    public static String getCurrentTime(){
        return simpleDateFormat.format(System.currentTimeMillis());
    }

    public static long getCurrentDate(){
        return System.currentTimeMillis();
    }
}
