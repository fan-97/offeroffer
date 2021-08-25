package com.date;


import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author fanjie
 * @date 2020/12/17 21:48
 */
public class LocalDateTimeUtil {

    /**
     * 默认 +8 区 时区
     */
    private static final ZoneOffset OFF_SET = ZoneOffset.of("+8");

    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(1);
        System.out.println(between(localDateTimeToMilli(today), localDateTimeToMilli(tomorrow), ChronoUnit.YEARS));
    }

    /**
     * 计算两个时间戳之间的时间间隔
     *
     * @param startTime
     * @param endTime
     * @param unit
     * @return 返回 unit时间单元 endTime-startTime 的差值 . 默认返回分钟
     */
    public static long between(long startTime, long endTime, ChronoUnit unit) {
        LocalDateTime startTimeLDT = milliToLocalDateTime(startTime);
        LocalDateTime endTimeLDT = milliToLocalDateTime(endTime);
        Duration between = Duration.between(startTimeLDT, endTimeLDT);
        switch (unit) {
            case DAYS:
                return between.toDays();
            case HOURS:
                return between.toHours();
            case NANOS:
                return between.toNanos();
            case MILLIS:
                return between.toMillis();
            default:
                return between.toMinutes();
        }
    }

    /**
     * 将时间戳转换成LocalDateTime对象
     * 时区为+8区 北京时间
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime milliToLocalDateTime(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), OFF_SET);
    }

    /**
     * 将毫秒值转成LocalDateTime对象
     *
     * @param localDateTime
     * @return
     */
    public static long localDateTimeToMilli(LocalDateTime localDateTime) {
//        Assert.notNull(localDateTime, "参数错误");
        return localDateTime.toInstant(OFF_SET).toEpochMilli();
    }

    public static long localDateToMilli(LocalDate localDate) {
//        Assert.notNull(localDate, "参数错误");
        return localDateTimeToMilli(localDate.atStartOfDay());
    }

}
