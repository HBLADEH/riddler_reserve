package com.pjboy.riddler_reserve.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    /**
     * 当前时间向推几小时
     *
     * @param hour 小时
     * @return String
     */
    public static String dateRoll(int hour) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //（1）获取当前时间
        LocalDateTime date = LocalDateTime.now();
        //（2）获取当前时间的前几小时时间
        LocalDateTime localDateTime = date.minusHours(hour);

        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 取到 hours 以前时间
     * @param hours
     * @return
     */
    public static Date headDate(String date ,int hours) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date));
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return cal.getTime();
    }
}
