package com.cn.connext.project.demo.util;

import java.time.LocalDateTime;

public class ChartTimeInterval {
    public LocalDateTime beginTime;
    public LocalDateTime endTime;

    public ChartTimeInterval(String beginTime, String endTime) {
        this.beginTime = LocalDateTime.parse(beginTime, ChartDataBuilder.LONG_DATE_TIME_FORMATTER);
        this.endTime = LocalDateTime.parse(endTime, ChartDataBuilder.LONG_DATE_TIME_FORMATTER);
    }
}
