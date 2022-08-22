package com.sgt.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liubin
 * @date 2019/1/15
 */
public final class MyDateUtils {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyDateUtils.class);

    public static final String FORMAT_YYYY = "yyyy";
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_HH_MM = "HH:mm";
    public static final String POINT_FORMAT_YYYY_MM_DD = "yyyy.MM.dd";
    public static final String POINT_FORMAT_YYYY_MM_DD_HH_MM = "yyyy.MM.dd HH:mm";
    public static final String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YMDHMS_SHORT = "yyyy-MM-d HH:mm:ss";
    public static final String FORMAT_YMDHM = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_YMDHMS_TIGHT = "yyyyMMddHHmmss";

    public static final String FORMAT_YYYYMMDD_CN = "yyyy年MM月dd日";
    public static final String FORMAT_YYYYMMDD_CN_SHORT = "yyyy年M月d日";

    private static final ZoneId SYSTEM_DEFAULT = ZoneId.systemDefault();

    private static final DateTimeFormatter FORMATTER_YYYYMMDD = DateTimeFormatter.ofPattern(FORMAT_YYYYMMDD);

    /**
     * 去掉时分秒,  yyyy-MM-dd 00:00:00
     *
     * @param date
     * @return Date
     */
    public static Date getYmdTime(final Date date) {
        if (date == null) {
            return new Date();
        }

        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        Date convertTime = day.getTime();
        return convertTime;
    }

    /**
     * 去掉秒,  yyyy-MM-dd hh:mm:00
     *
     * @param date
     * @return Date
     */
    public static Date getYmdhhmmTime(final Date date) {
        if (date == null) {
            return new Date();
        }

        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        Date convertTime = day.getTime();
        return convertTime;
    }

    /**
     * 转换日期
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date parse(String dateStr, String... format) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }

        try {
            return DateUtils.parseDate(dateStr, format);
        } catch (ParseException e) {
            LOGGER.error("日期转换失败! dateStr = {}, patterns = {}", dateStr, format);
            return null;
        }
    }

    /**
     * 获取日期指定的格式的字符串
     *
     * @param date
     * @param pattern
     * @return Date 对象类型字符串形式
     */
    public static String format(Date date, String pattern) {
        if (null != date) {
            DateFormat dateFomat = new SimpleDateFormat(pattern);
            return dateFomat.format(date);
        }
        return "";
    }

    /**
     * 去掉分秒
     *
     * @param date
     * @return Date
     */
    public static Date getYmdHTime(final Date date) {
        if (date == null) {
            return new Date();
        }
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);
        Date convertTime = day.getTime();
        return convertTime;
    }

    /**
     * 用yyyy-MM-dd T HH:mm:ss Z来格式化日期字符串
     *
     * @param s
     * @return 如果s==null或者格式异常，返回null
     */
    public static Date getYyyyMMddTZDate(String s) {
        if (StringUtils.isBlank(s)) {
            return null;
        }

        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(s);
        } catch (ParseException e) {
            LOGGER.error("格式转化错误，string=" + s, e);
            return null;
        }
    }

    public static Date getDateByFormat(String format, String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }

        try {
            return new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取指定日期的 最后时间点 yyyy-MM-dd 23:59:59
     *
     * @param
     * @author FE
     * @date 2018/11/12
     * @version V1.0
     **/
    public static Date getDataEndTime(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        // 将秒至0
        calendar.set(Calendar.SECOND, 0);
        // 将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        // 让日期加1
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        // 在当前时间的基础上减去1毫秒
        calendar.add(Calendar.MILLISECOND, -1);
        // 获得当前时间0点的 的最后一天
        return calendar.getTime();
    }

    /**
     * 新增天数
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addDays(final Date date, final int amount) {
        return DateUtils.addDays(date, amount);
    }

    /**
     * 获取当前日期是星期几（数字类型1-7，7代表周日）
     *
     * @param date
     * @return 当前日期是星期几（数字类型1-7，7代表周日）
     */
    public static int getWeekday(Date date) {
        if (null == date) {
            return 1;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w <= 0) {
            w = 7;
        }

        return w;
    }

    /**
     * 根据周几（1～7）获取今天之后最近的日期
     *
     * @param weekday 1:周一 2:周二 ... 7:周日
     * @return
     */
    public static Date getAfterByWeekday(Integer weekday) {
        if (null == weekday || weekday < 1 || weekday > 7) {
            LOGGER.error("静态排班的weekday值不在正常范围内，请检查：[" + weekday + "]");
            return null;
        }

        int d = weekday.intValue();
        // Calendar中周日为第一天，即 1:周日 2:周一 ... 7:周六，需要转换
        d = d % 7 + 1;
        Calendar calendar = Calendar.getInstance();
        // 当天是周几
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.set(Calendar.DAY_OF_WEEK, d);

        // 当天之前的（包括当天），取下周的这天
        if (d <= week) {
            calendar.add(Calendar.WEEK_OF_MONTH, 1);
        }

        return calendar.getTime();
    }

    /**
     * 根据日期获取年，eg：2019年
     *
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        if (null == date) {
            return "";
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) + "";
    }

    public static Integer getCurrentYear(Date date) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取两个日期相差几年，eg：2年
     *
     * @param min
     * @param max
     * @return
     */
    public static String getDiffYear(Date min, Date max) {
        Calendar minCalendar = Calendar.getInstance();
        minCalendar.setTime(min);

        Calendar maxCalendar = Calendar.getInstance();
        maxCalendar.setTime(max);

        int minYear = minCalendar.get(Calendar.YEAR);
        int maxYear = maxCalendar.get(Calendar.YEAR);

        int duration = maxYear - minYear;
        if (duration == 0) {
            duration = 1;
        }

        return duration + "年";
    }

    /**
     * 得到两个日期间的天数
     *
     * @param startDate 开始日期
     * @param endDate   结束
     * @return
     */
    public static Integer getDiffDays(Date startDate, Date endDate) {
        long time = endDate.getTime() - startDate.getTime();
        long day = time / (1000 * 60 * 60 * 24);
        return Math.toIntExact(day);
    }

    /**
     * 获得两个日期间的月数
     */
    public static Integer getDiffMonths(Date startDate, Date endDate) {
        if (startDate.after(endDate)) {
            return 0;
        }

        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        Integer year = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        Integer month = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        if (month < 0) {
            month += Calendar.UNDECIMBER;
            year--;
        }

        Integer diffMonth = month + year * Calendar.UNDECIMBER;
        return diffMonth;
    }

    /**
     * 根据患者生日查询患者年龄（单位：天）
     *
     * @param birthDay
     * @return
     */
    public static Integer getLivingDay(String birthDay, String pattern) {
        if (StringUtils.isBlank(birthDay) || StringUtils.isBlank(pattern)) {
            return null;
        }

        Date birthday = MyDateUtils.parse(birthDay, pattern);
        if (null == birthDay) {
            return null;
        }

        long birthTime = birthday.getTime();
        long currentTime = System.currentTimeMillis();
        long liveDays = (currentTime - birthTime) / (24 * 60 * 60 * 1000);

        return Math.toIntExact(liveDays);

    }

    /**
     * LocalDate -> Date
     *
     * @param localDate
     * @return
     */
    public static Date toDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return Date.from(localDate.atStartOfDay(SYSTEM_DEFAULT).toInstant());
    }

    /**
     * localDateTime -> Date
     *
     * @param localDateTime
     * @return
     */
    public static Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(SYSTEM_DEFAULT).toInstant());
    }

    /**
     * 解析为localDate
     *
     * @param yyyyMMdd
     * @return
     */
    public static LocalDate yyyyMMddToLocalDate(String yyyyMMdd) {
        if (yyyyMMdd == null) {
            return null;
        }
        try {
            return LocalDate.parse(yyyyMMdd, FORMATTER_YYYYMMDD);
        } catch (Exception e) {
            LOGGER.error("解析日期失败:yyyyMMdd={}", yyyyMMdd, e);
        }
        return null;
    }

    /**
     * @param date
     * @return
     * @description: 获得当天最小时间
     * @author: gf
     */
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime
            .ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * @param date
     * @return
     * @description: 获得当天最大时间
     * @author: gf
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime
            .ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * @param viewDay
     * @return
     */
    public static String getStartOfDayStr(String viewDay) {
        Date date = new Date();
        if (StringUtils.isNotBlank(viewDay)) {
            try {
                date = DateUtils.parseDate(viewDay, FORMAT_YYYY_MM_DD);
            } catch (ParseException e) {
            }
        }
        date = getStartOfDay(date);
        return DateFormatUtils.format(date, FORMAT_YMDHMS);
    }

    /**
     * @param viewDay
     * @return
     */
    public static String getEndOfDayStr(String viewDay) {
        Date date = new Date();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(viewDay)) {
            try {
                date = DateUtils.parseDate(viewDay, FORMAT_YYYY_MM_DD);
            } catch (ParseException e) {
            }
        }
        date = getEndOfDay(date);
        return DateFormatUtils.format(date, FORMAT_YMDHMS);
    }

    /**
     * 获取指定日期的 最后时间点 yyyy-MM-dd 23:59:59
     *
     * @param
     * @author FE
     * @date 2018/11/12
     * @version V1.0
     **/
    public static Date getEndTime(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        // 将秒至0
        calendar.set(Calendar.SECOND, 0);
        // 将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        // 让日期加1
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        // 在当前时间的基础上减去1毫秒
        calendar.add(Calendar.MILLISECOND, -1);
        // 获得当前时间0点的 的最后一天
        return calendar.getTime();
    }

    public static Date getStartTime(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        // 将秒至0
        calendar.set(Calendar.SECOND, 0);
        // 将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 新增年
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addYear(final Date date, final int amount) {
        return DateUtils.addYears(date, amount);
    }

    /**
     * 新增月
     *
     * @param date
     * @param amount
     * @return
     */
    public static Date addMonth(final Date date, final int amount) {
        return DateUtils.addMonths(date, amount);
    }

    /**
     * 加上小时
     * @param date
     * @param amount
     * @return
     */
    public static Date addHours(final Date date, final int amount) {
        return DateUtils.addHours(date, amount);
    }


    /**
     * 得到UTC时间，类型为字符串，格式为"yyyy-MM-dd HH:mm"<br />
     * 如果获取失败，返回null
     *
     * @return
     */
    public static String getUTCTimeStr() {
        return getUTCTimeStr(null, null);
    }

    /**
     * 得到UTC时间，类型为字符串，格式为"yyyy-MM-dd HH:mm"<br />
     * 如果获取失败，返回null
     *
     * @return
     */
    public static String getUTCTimeStr(String dateStr, String formatStr) {
        if (StringUtils.isEmpty(formatStr)) {
            formatStr = FORMAT_YMDHM;
        }
        DateFormat format = new SimpleDateFormat(formatStr);

        StringBuffer UTCTimeBuffer = new StringBuffer();
        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance();
        if (StringUtils.isNotEmpty(dateStr)) {
            Date dateExecute = null;
            try {
                dateExecute = format.parse(dateStr);
            } catch (ParseException e) {

            }
            cal.setTime(dateExecute);
        }
        // 2、取得时间偏移量：
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
        // 3、取得夏令时差：
        int dstOffset = cal.get(Calendar.DST_OFFSET);
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        UTCTimeBuffer.append(year).append("-").append(month).append("-").append(day);
        UTCTimeBuffer.append(" ").append(hour).append(":").append(minute);
        try {
            format.parse(UTCTimeBuffer.toString());
            return UTCTimeBuffer.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Date类型转成LocalDateTime类型
     *
     * @param date Date类型时间
     * @return LocalDateTime类型的时间
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * LocalDateTime类型转Date类型
     * @param localDateTime LocalDateTime类型时间
     * @return Date类型时间
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 根据当前时间获取已经过去的的季度的结束时间
     * @param date 当前时间
     * @return 季度的结束时间
     */
    public static List<Date> getQuarterEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        List<Date> dateList = new ArrayList<>();
        if (month >= 4) {
            Calendar qa1 = Calendar.getInstance();
            qa1.set(calendar.get(Calendar.YEAR), Calendar.APRIL, 31, 0, 0, 0);
            dateList.add(qa1.getTime());
        }
        if (month >= 7) {
            Calendar qa2 = Calendar.getInstance();
            qa2.set(calendar.get(Calendar.YEAR), Calendar.JULY, 30, 0, 0, 0);
            dateList.add(qa2.getTime());
        }
        if (month >= 10) {
            Calendar qa3 = Calendar.getInstance();
            qa3.set(calendar.get(Calendar.YEAR), Calendar.OCTOBER, 30, 0, 0, 0);
            dateList.add(qa3.getTime());
        }
        dateList.add(date);
        return dateList;
    }

    public static void main(String args[]) {

    }
}
