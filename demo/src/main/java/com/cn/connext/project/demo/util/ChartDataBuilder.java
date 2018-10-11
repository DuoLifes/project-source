package com.cn.connext.project.demo.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class ChartDataBuilder {
    public final static DateTimeFormatter LONG_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public final static DateTimeFormatter YEAR_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-01-01 00:00:00");
    public final static DateTimeFormatter MONTH_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-01 00:00:00");
    public final static DateTimeFormatter DAY_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
    public final static DateTimeFormatter HOUR_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:00:00");

    private final static DateTimeFormatter YEAR_AXIS_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy");
    private final static DateTimeFormatter MONTH_AXIS_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("M月");
    private final static DateTimeFormatter DAY_AXIS_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM-dd");
    private final static DateTimeFormatter HOUR_AXIS_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:00");

    /*获取时间段：beginTime-endTime*/
    public static ChartTimeInterval getTimeIntervalByType(String dateIntervalType) {
        String beginTime = null;
        String endTime = null;

        switch (dateIntervalType) {
            case "y":
                beginTime = LocalDateTime.now().plusYears(-4).format(YEAR_DATE_TIME_FORMATTER);
                endTime = LocalDateTime.now().plusYears(1).format(YEAR_DATE_TIME_FORMATTER);
                break;

            case "m":
                beginTime = LocalDateTime.now().plusMonths(-11).format(MONTH_DATE_TIME_FORMATTER);
                endTime = LocalDateTime.now().plusMonths(1).format(MONTH_DATE_TIME_FORMATTER);
                break;

            case "d":
                beginTime = LocalDateTime.now().plusDays(-14).format(DAY_DATE_TIME_FORMATTER);
                endTime = LocalDateTime.now().plusDays(1).format(DAY_DATE_TIME_FORMATTER);
                break;

            default:
                beginTime = LocalDateTime.now().plusHours(-11).format(HOUR_DATE_TIME_FORMATTER);
                endTime = LocalDateTime.now().plusHours(1).format(HOUR_DATE_TIME_FORMATTER);
        }

        return new ChartTimeInterval(beginTime, endTime);
    }

    public static void buildChartData(LocalDateTime beginTime, LocalDateTime endTime, String dateIntervalType, CommonChartDataBuilder commonChartDataBuilder) {
        LocalDateTime curTime = beginTime;
        switch (dateIntervalType) {
            case "y":
                while (curTime.isBefore(endTime)) {
                    String axisName = curTime.format(YEAR_AXIS_DATE_TIME_FORMATTER);
                    String key = Long.toString(curTime.atOffset(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
                    commonChartDataBuilder.build(axisName, key);
                    curTime = curTime.plusYears(1);
                }
                break;

            case "m":
                while (curTime.isBefore(endTime)) {
                    String axisName = curTime.format(MONTH_AXIS_DATE_TIME_FORMATTER);
                    String key = Long.toString(curTime.atOffset(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
                    commonChartDataBuilder.build(axisName, key);
                    curTime = curTime.plusMonths(1);
                }
                break;

            case "d":
                while (curTime.isBefore(endTime)) {
                    String axisName = curTime.format(DAY_AXIS_DATE_TIME_FORMATTER);
                    String key = Long.toString(curTime.atOffset(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
                    commonChartDataBuilder.build(axisName, key);
                    curTime = curTime.plusDays(1);
                }

            default:
                while (curTime.isBefore(endTime)) {
                    String axisName = curTime.format(HOUR_AXIS_DATE_TIME_FORMATTER);
                    String key = Long.toString(curTime.atOffset(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
                    commonChartDataBuilder.build(axisName, key);
                    curTime = curTime.plusHours(1);
                }
        }
    }

    public interface CommonChartDataBuilder {
        void build(String axisName, String key);
    }
    /*获取一年前的时间*/
    public static String pastYear(String time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String year = "";
        try {
            Calendar c = Calendar.getInstance();
            //过去一年
            c.setTime(format.parse(time));
            c.add(Calendar.YEAR, -1);
            Date y = c.getTime();
            year = format.format(y);
        }catch (Exception e){

        }
        return year;
    }
    /*获取当前时间前一个月*/
    public static String pastMon(String time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mon = "";
        try {
            Calendar c = Calendar.getInstance();
            //过去一年
            c.setTime(format.parse(time));
            c.add(Calendar.MONTH, -1);
            Date y = c.getTime();
            mon = format.format(y);
        }catch (Exception e){

        }
        return mon;
    }

    /**
     * 时间差(天为单位)
     */
    public static Double timeDifference(String fromDate,String toDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Double days= 0D;
        try {
            long from = format.parse(fromDate).getTime();
            long to = format.parse(toDate).getTime();
            Double seconds = (double) ((to - from)/(1000));
            days = seconds/60/60/24;
        }catch (Exception e){

        }
        return days;
    }


}
