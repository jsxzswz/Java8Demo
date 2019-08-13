package com.swz;

import java.time.*;

/**
 * @Package: com.swz
 * @Description: 日期时间API
 * @author: swz
 * @date: 2018/11/30 14:23
 */
public class DateTimeTest {

    /**
     * 1.在旧版的Java 中，日期时间API 存在诸多问题:
     * a.非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一;
     * b.设计很差 − Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类;
     * c.时区处理麻烦 − 日期类并不提供国际化，没有时区支持;
     * <p>
     * 2.Java 8 在 java.time 包下提供了很多新的 API
     * a.Local(本地) − 简化了日期时间的处理，没有时区的问题;
     * b.Zoned(时区) − 通过制定的时区处理日期时间;
     * <p>
     * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作.
     */
    public static void main(String[] args) {

        // LocalDate/LocalTime 和 LocalDateTime 类可以在处理时区不是必须的情况
        DateTimeTest dateTimeTest = new DateTimeTest();
        dateTimeTest.testLocalDateTime();
        // 如果我们需要考虑到时区，就可以使用时区的日期时间API
        dateTimeTest.testZonedDateTime();
    }

    public void testLocalDateTime() {
        // 获取当前的日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间：" + localDateTime);
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println("localDate:" + localDate);
        Month month = localDateTime.getMonth();
        int day = localDateTime.getDayOfMonth();
        int hours = localDateTime.getHour();
        int minutes = localDateTime.getMinute();
        int seconds = localDateTime.getSecond();
        System.out.println("月：" + month + ",日: " + day + ",时：" + hours + ",分：" + minutes + ",秒: " + seconds);

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10).withYear(2018);
        System.out.println("localDateTime1:" + localDateTime1);
        // 2018-11-28
        LocalDate localDate1 = LocalDate.of(2018, Month.NOVEMBER, 28);
        System.out.println("localDate1:" + localDate1);
        // 22:35
        LocalTime localTime = LocalTime.of(22, 30);
        System.out.println("localTime:" + localTime);
        // 解析字符串
        LocalTime localTime1 = LocalTime.parse("22:35:24");
        System.out.println("localTime1" + localTime1);
    }

    public void testZonedDateTime() {
        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }

}
