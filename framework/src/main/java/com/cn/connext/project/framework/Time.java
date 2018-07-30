package com.cn.connext.project.framework;

import com.cn.connext.project.framework.exception.ServiceException;
import org.apache.commons.lang.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Chenghan on 2017/12/12.
 */
public class Time {
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Date getLocalTime(String timestamp) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(1970, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.add(Calendar.MILLISECOND, TimeZone.getDefault().getRawOffset());
        calendar.add(Calendar.SECOND, Integer.parseInt(timestamp));
        return calendar.getTime();
    }

    public static Date parseFromString(String string) {
        try {
            if (!string.contains(":")) string = string + " 00:00:00";
            return SIMPLE_DATE_FORMAT.parse(string);
        } catch (ParseException e) {
            throw new ServiceException("global_error_dateFormat");
        }
    }

    public static LocalDateTime parseBeginTime(String string) {
        if (StringUtils.isEmpty(string)) return null;
        try {
            if (!string.contains(":")) string = string + " 00:00:00";
            return LocalDateTime.parse(string, DATE_TIME_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalDateTime parseEndTime(String string) {
        if (StringUtils.isEmpty(string)) return null;
        try {
            if (!string.contains(":")) {
                string = string + " 00:00:00";
                return LocalDateTime.parse(string, DATE_TIME_FORMATTER).plusDays(1);
            } else {
                return LocalDateTime.parse(string, DATE_TIME_FORMATTER);
            }
        } catch (Exception e) {
            return null;
        }
    }


    public static String getFormatTime(Date currentTime) {
        return getFormatTime(currentTime, "yyyy-MM-dd HH:mm:ss");
    }


    public static String getFormatTime(Date currentTime, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(currentTime);
    }
}
