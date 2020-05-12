package com.tjetc.util;

import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    /**
     * 获取当天的时刻时间戳
     *
     * @return 当天的时刻时间戳
     */
    public static long getTodayTime(int h,int m,int s) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, s);
        calendar.set(Calendar.MINUTE, m);
        calendar.set(Calendar.SECOND, s);
        return calendar.getTime().getTime();
    }

}
