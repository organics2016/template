package ink.organics.openjdk11.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

/**
 * Created by 王汗超 on 2017/6/12.
 */
public class DateUtils {


    private DateUtils() {
    }

    public static final DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final DateTimeFormatter stf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static LocalDate getLocalDate(String localDate) {
        return LocalDate.parse(localDate, sf);
    }

    public static LocalDateTime getLocalDateTime(String localDateTime) {
        return LocalDateTime.parse(localDateTime, stf);
    }

    public static String getLocalDateTimeString(LocalDateTime localDateTime) {
        return localDateTime.format(stf);
    }

    public static String getLocalDateString(LocalDate localDate) {
        return localDate.format(sf);
    }


    public static LocalDateTime getDayStart(String start) {
        return getDayStart(LocalDate.parse(start, sf));
    }

    public static LocalDateTime getDayEnd(String end) {
        return getDayEnd(LocalDate.parse(end, sf));
    }


    public static LocalDateTime getDayStart(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.MIN);
    }

    public static LocalDateTime getDayEnd(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.MAX);
    }


    public static LocalDateTime getWeekStart(LocalDate localDate) {
        return LocalDateTime.of(localDate.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1), LocalTime.MIN);
    }

    public static LocalDateTime getWeekEnd(LocalDate localDate) {
        return LocalDateTime.of(localDate.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 7), LocalTime.MAX);
    }

    public static LocalDateTime getMonthStart(LocalDate localDate) {
        return LocalDateTime.of(localDate.with(TemporalAdjusters.firstDayOfMonth()), LocalTime.MIN);
    }

    public static LocalDateTime getMonthEnd(LocalDate localDate) {
        return LocalDateTime.of(localDate.with(TemporalAdjusters.lastDayOfMonth()), LocalTime.MAX);
    }

    /**
     * 获取顺延工作日,如果是工作日,则返回参数本身
     *
     * @param localDate
     * @return
     */
    public static LocalDate getWorkday(LocalDate localDate) {
        LocalDate saturday = localDate.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 7);
        LocalDate sunday = localDate.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);
        if (localDate.isEqual(saturday)) {
            return localDate.plusDays(2);
        } else if (localDate.isEqual(sunday)) {
            return localDate.plusDays(1);
        } else {
            return localDate;
        }
    }
}
