package com.edu.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * time
 *
 * @author: unascribed
 * @create: 2019-12-18
 **/
public class TestTime {

    @Test
    public void test() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);

        //字符串转时间戳
        String str = "2019-12-18 11:01:09";
        Long convertTimeToLong = convertTimeToLong(str);
        System.out.println("convertTimeToLong = " + convertTimeToLong);

        //时间戳转字符串
        String convertTimeToString = convertTimeToString(convertTimeToLong);
        System.out.println("convertTimeToString = " + convertTimeToString);
        
    }

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    public static Long convertTimeToLong(String time) {
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(Long time) {
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }


}
