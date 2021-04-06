package org.tiankafei.common.datetime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.common.constants.DateTimeConstants;
import org.tiankafei.common.dto.CodeNameDTO;
import org.tiankafei.common.enums.DateTimeEnum;
import org.tiankafei.common.exceptions.CommonException;
import org.tiankafei.common.util.SystemTimeUtil;

/**
 * 时间处理工具类
 *
 * @author tiankafei
 * @since 1.0
 **/
public class DateTimeUtil {

    private DateTimeUtil() {

    }

    /**
     * date类型转换为String类型
     *
     * @param data       Date类型的时间
     * @param formatType 时间格式类型
     * @return 返回date类型转换为String类型的时间
     */
    public static String dateToString(Date data, String formatType) {
        if (data == null || StringUtils.isEmpty(formatType)) {
            return null;
        }
        return new SimpleDateFormat(formatType).format(data);
    }

    /**
     * date类型转换为long类型
     *
     * @param date 要转换的date类型的时间
     * @return 返回date类型转换为long类型的时间
     */
    public static long dateToLong(Date date) {
        if (date == null) {
            return -1;
        }
        return date.getTime();
    }

    /**
     * String类型转换为Timestamp类型
     *
     * @param date       需要转换的时间值
     * @param formatType 需要转换的格式
     * @return 返回String类型转换为Timestamp类型的时间
     */
    public static Timestamp dateToTimestamp(Date date, String formatType) {
        if (date == null || StringUtils.isEmpty(formatType)) {
            return null;
        }
        String currentTime = dateToString(date, formatType);
        return stringToTimestamp(currentTime, formatType);
    }

    /**
     * long类型转换为String类型
     *
     * @param currentTime 要转换的long类型的时间
     * @param formatType  要转换的string类型的时间格式
     * @return 返回long类型转换为String类型的时间
     */
    public static String longToString(long currentTime, String formatType) {
        if (currentTime == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = longToDate(currentTime, formatType);
        String strTime = dateToString(date, formatType);
        return strTime;
    }

    /**
     * long转换为Date类型
     *
     * @param currentTime 要转换的long类型的时间
     * @param formatType  要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
     * @return 返回long转换为Date类型的时间
     */
    public static Date longToDate(long currentTime, String formatType) {
        if (currentTime == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date dateOld = new Date(currentTime);
        String sDateTime = dateToString(dateOld, formatType);
        Date date = stringToDate(sDateTime, formatType);
        return date;
    }

    /**
     * String类型转换为Timestamp类型
     *
     * @return 返回String类型转换为Timestamp类型的时间
     */
    public static Timestamp longToTimestamp() {
        return longToTimestamp(System.currentTimeMillis());
    }

    /**
     * String类型转换为Timestamp类型
     *
     * @param time 需要转换的时间值
     * @return 返回String类型转换为Timestamp类型的时间
     */
    public static Timestamp longToTimestamp(Long time) {
        if (time == null) {
            return null;
        }
        return new Timestamp(time);
    }

    /**
     * Timestamp类型转换为String类型
     *
     * @param timestamp  需要转换的时间值
     * @param formatType 需要转换的格式
     * @return 返回Timestamp类型转换为String类型的时间
     */
    public static String timestampToString(Timestamp timestamp, String formatType) {
        if (timestamp == null || StringUtils.isEmpty(formatType)) {
            return null;
        }
        DateFormat sdf = new SimpleDateFormat(formatType);
        String strTime = sdf.format(timestamp);
        return strTime;
    }

    /**
     * Timestamp类型转换为Date类型
     *
     * @param timestamp 需要转换的时间值
     * @return 返回Timestamp类型转换为String类型的时间
     */
    public static Date timestampToDate(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        DateFormat sdf = new SimpleDateFormat(DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode());
        String strTime = sdf.format(timestamp);

        return stringToDate(strTime, DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode());
    }

    /**
     * Timestamp类型转换为Date类型
     *
     * @param timestamp 需要转换的时间值
     * @return 返回Timestamp类型转换为String类型的时间
     */
    public static long timestampToLong(Timestamp timestamp) {
        if (timestamp == null) {
            return -1;
        }
        DateFormat sdf = new SimpleDateFormat(DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode());
        String strTime = sdf.format(timestamp);

        return stringToLong(strTime, DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode());
    }

    /**
     * string类型转换为date类型(strTime的时间格式必须要与formatType的时间格式相同)
     *
     * @param strTime    要转换的string类型的时间
     * @param formatType 要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
     * @return 返回string类型转换为date类型的时间
     */
    public static Date stringToDate(String strTime, String formatType) {
        try {
            if (StringUtils.isEmpty(strTime) || StringUtils.isEmpty(formatType)) {
                return null;
            }
            SimpleDateFormat formatter = new SimpleDateFormat(formatType);
            Date date = formatter.parse(strTime);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new CommonException("要转换的时间格式错误，请检查！");
        }
    }

    /**
     * string类型转换为long类型(strTime的时间格式和formatType的时间格式必须相同)
     *
     * @param strTime    要转换的String类型的时间
     * @param formatType 时间格式
     * @return 返回string类型转换为long类型的时间
     */
    public static long stringToLong(String strTime, String formatType) {
        if (StringUtils.isEmpty(strTime) || StringUtils.isEmpty(formatType)) {
            return -1;
        }
        // String类型转成date类型
        Date date = stringToDate(strTime, formatType);
        if (date == null) {
            return -1;
        } else {
            // date类型转成long类型
            long currentTime = dateToLong(date);
            return currentTime;
        }
    }

    /**
     * String类型转换为Timestamp类型
     *
     * @param strTime    需要转换的时间值
     * @param formatType 需要转换的格式
     * @return 返回String类型转换为Timestamp类型的时间
     */
    public static Timestamp stringToTimestamp(String strTime, String formatType) {
        if (StringUtils.isEmpty(strTime) || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Timestamp timestamp = new Timestamp(SystemTimeUtil.now());
        timestamp.setTime(stringToLong(strTime, formatType));
        return timestamp;
    }

    /**
     * 获取当前时间
     *
     * @param formatType 时间格式
     * @return 当前时间
     */
    public static String getCurrentTime(String formatType) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);
        Calendar calendar = Calendar.getInstance();
        return simpleDateFormat.format(calendar.getTime());
    }

    /**
     * 获取当前时间
     *
     * @param calendar   时间对象
     * @param formatType 时间格式
     * @return 当前时间
     */
    public static String getCurrentTime(Calendar calendar, String formatType) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);
        return simpleDateFormat.format(calendar.getTime());
    }

    /**
     * 获取当前年份
     *
     * @return 返回当前年份
     */
    public static int getCurrentYear() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        return cal.get(GregorianCalendar.YEAR);
    }

    /**
     * 获取传入数值的年份
     *
     * @param date 要获取年份的数值
     * @return 返回传入数值的年份
     */
    public static int getCurrentYear(Date date) {
        if (date == null) {
            return -1;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(GregorianCalendar.YEAR);
    }

    /**
     * 获取传入数值的年份
     *
     * @param timestamp 要获取年份的数值
     * @return 返回传入数值的年份
     */
    public static int getCurrentYear(Timestamp timestamp) {
        if (timestamp == null) {
            return -1;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(timestamp);
        return cal.get(GregorianCalendar.YEAR);
    }

    /**
     * 获取当前月份
     *
     * @return 返回当前月份
     */
    public static int getCurrentMonth() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        return cal.get(GregorianCalendar.MONTH) + 1;
    }

    /**
     * 获取传入时间的月份
     *
     * @param date 获取传入时间的月份
     * @return 返回传入时间的月份
     */
    public static int getCurrentMonth(Date date) {
        if (date == null) {
            return -1;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(GregorianCalendar.MONTH) + 1;
    }

    /**
     * 获取传入时间的月份
     *
     * @param timestamp 获取传入时间的月份
     * @return 返回传入时间的月份
     */
    public static int getCurrentMonth(Timestamp timestamp) {
        if (timestamp == null) {
            return -1;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(timestamp);
        return cal.get(GregorianCalendar.MONTH) + 1;
    }

    /**
     * 获取当前月的第几天
     *
     * @return 返回当前月的第几天
     */
    public static int getCurrentDayOfMonth() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        return cal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前月的第几天
     *
     * @param date
     * @return 前月的第几天
     */
    public static int getCurrentDayOfMonth(Date date) {
        if (date == null) {
            return -1;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前月的第几天
     *
     * @param timestamp
     * @return 前月的第几天
     */
    public static int getCurrentDayOfMonth(Timestamp timestamp) {
        if (timestamp == null) {
            return -1;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(timestamp);
        return cal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前年的第几天
     *
     * @return 返回前年的第几天
     */
    public static int getCurrentDayOfYear() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        return cal.get(GregorianCalendar.DAY_OF_YEAR);
    }

    /**
     * 获取当前年的第几天
     *
     * @param date
     * @return 返回前年的第几天
     */
    public static int getCurrentDayOfYear(Date date) {
        if (date == null) {
            return -1;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(GregorianCalendar.DAY_OF_YEAR);
    }

    /**
     * 获取当前年的第几天
     *
     * @param timestamp
     * @return 返回前年的第几天
     */
    public static int getCurrentDayOfYear(Timestamp timestamp) {
        if (timestamp == null) {
            return -1;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(timestamp);
        return cal.get(GregorianCalendar.DAY_OF_YEAR);
    }

    /**
     * 获取当前天的第几分钟
     *
     * @return 返回前天的第几分钟
     */
    public static int getCurrentMinuteOfDay() {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        return cal.get(GregorianCalendar.MINUTE);
    }

    /**
     * 获取当前天的第几分钟
     *
     * @param date
     * @return 返回前天的第几分钟
     */
    public static int getCurrentMinuteOfDay(Date date) {
        if (date == null) {
            return -1;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(GregorianCalendar.MINUTE);
    }

    /**
     * 获取当前天的第几分钟
     *
     * @param timestamp
     * @return 返回前天的第几分钟
     */
    public static int getCurrentMinuteOfDay(Timestamp timestamp) {
        if (timestamp == null) {
            return -1;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(timestamp);
        return cal.get(GregorianCalendar.MINUTE);
    }

    /**
     * 获取传入的那一年的那一个月有多少天
     *
     * @param year  年份
     * @param month 月份
     * @return 返回某年某月的天数
     */
    public static int getMonthOfDays(int year, int month) {
        if (year == 0 || month == 0) {
            return -1;
        }
        int days = 0;
        boolean flag = getYearType(year);
        if (flag) {
            //平年
            days = DateTimeConstants.AVERAGE_YEAR_MONTH_OF_DAYS[month - 1];
        } else {
            //闰年
            days = DateTimeConstants.LEAP_YEAR_MONTH_OF_DAYS[month - 1];
        }
        return days;
    }

    /***
     * 获取年份是平年还是闰年
     * @param year    传入的年份
     * @return false为闰年，true为平年
     */
    public static boolean getYearType(int year) {
        boolean flag = true;
        int number4 = 4;
        int number100 = 100;
        int number400 = 400;
        if (year % number4 == 0) {
            if (year % number100 == 0) {
                if (year % number400 == 0) {
                    flag = false;
                }
            } else {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 获取传入的时间往后推一定年数的时间
     *
     * @param strTime    传入需要往后推的时间
     * @param year       往后推的年数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定年数的时间
     */
    public static String afterYear(String strTime, int year, String formatType) {
        if (StringUtils.isEmpty(strTime) || year == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = afterYear(date, year);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定年数的时间
     *
     * @param currentDate 传入需要往后推的时间
     * @param year        往后推的年数
     * @return 返回传入的时间往后推一定年数的时间
     */
    public static Date afterYear(Date currentDate, int year) {
        if (currentDate == null || year == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.YEAR, year);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往后推一定年数的时间
     *
     * @param timestamp  传入需要往后推的时间
     * @param year       往后推的年数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定年数的时间
     */
    public static Timestamp afterYear(Timestamp timestamp, int year, String formatType) {
        if (timestamp == null || year == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = afterYear(date, year);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定月数的时间
     *
     * @param strTime    传入需要往后推的时间
     * @param month      往后推的月数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定月数的时间
     */
    public static String afterMonth(String strTime, int month, String formatType) {
        if (StringUtils.isEmpty(strTime) || month == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = afterMonth(date, month);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定月数的时间
     *
     * @param currentDate 传入需要往后推的时间
     * @param month       往后推的月数
     * @return 返回传入的时间往后推一定月数的时间
     */
    public static Date afterMonth(Date currentDate, int month) {
        if (currentDate == null || month == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往后推一定月数的时间
     *
     * @param timestamp  传入需要往后推的时间
     * @param month      往后推的月数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定月数的时间
     */
    public static Timestamp afterMonth(Timestamp timestamp, int month, String formatType) {
        if (timestamp == null || month == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = afterMonth(date, month);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定周数(一年中的第几周)的时间
     *
     * @param strTime    传入需要往后推的时间
     * @param week       往后退的周数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定周数(一年中的第几周)的时间
     */
    public static String afterWeek(String strTime, int week, String formatType) {
        if (StringUtils.isEmpty(strTime) || week == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = afterWeek(date, week);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定周数(一年中的第几周)的时间
     *
     * @param currentDate 传入需要往后推的时间
     * @param week        往后退的周数(一年中的第几周)
     * @return 返回传入的时间往后推一定周数(一年中的第几周)的时间
     */
    public static Date afterWeek(Date currentDate, int week) {
        if (currentDate == null || week == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.WEEK_OF_YEAR, week);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往后推一定周数(一年中的第几周)的时间
     *
     * @param timestamp  传入需要往后推的时间
     * @param week       往后退的周数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定周数(一年中的第几周)的时间
     */
    public static Timestamp afterWeek(Timestamp timestamp, int week, String formatType) {
        if (timestamp == null || week == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = afterWeek(date, week);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定周数(一月中的第几周)的时间
     *
     * @param strTime    传入需要往后推的时间
     * @param week       往后退的周数(一月中的第几周)
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定周数(一月中的第几周)的时间
     */
    public static String afterWeekOfMonth(String strTime, int week, String formatType) {
        if (StringUtils.isEmpty(strTime) || week == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = afterWeekOfMonth(date, week);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定周数(一月中的第几周)的时间
     *
     * @param currentDate 传入需要往后推的时间
     * @param week        往后退的周数(一月中的第几周)
     * @return 返回传入的时间往后推一定周数(一月中的第几周)的时间
     */
    public static Date afterWeekOfMonth(Date currentDate, int week) {
        if (currentDate == null || week == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.WEEK_OF_MONTH, week);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往后推一定周数(一月中的第几周)的时间
     *
     * @param timestamp  传入需要往后推的时间
     * @param week       往后退的周数(一月中的第几周)
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定周数(一月中的第几周)的时间
     */
    public static Timestamp afterWeekOfMonth(Timestamp timestamp, int week, String formatType) {
        if (timestamp == null || week == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = afterWeekOfMonth(date, week);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定天数的时间
     *
     * @param strTime    传入需要往后推的时间
     * @param days       往后推的天数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定天数的时间
     */
    public static String afterDay(String strTime, int days, String formatType) {
        if (StringUtils.isEmpty(strTime) || days == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = afterDay(date, days);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定天数的时间
     *
     * @param currentDate 传入需要往后推的时间
     * @param days        往后推的天数
     * @return 返回传入的时间往后推一定天数的时间
     */
    public static Date afterDay(Date currentDate, int days) {
        if (currentDate == null || days == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往后推一定天数的时间
     *
     * @param timestamp  传入需要往后推的时间
     * @param days       往后推的天数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定天数的时间
     */
    public static Timestamp afterDay(Timestamp timestamp, int days, String formatType) {
        if (timestamp == null || days == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = afterDay(date, days);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定天数的时间
     *
     * @param strTime    传入需要往后推的时间
     * @param hours      往后推的小时数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定天数的时间
     */
    public static String afterHours(String strTime, int hours, String formatType) {
        if (StringUtils.isEmpty(strTime) || hours == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = afterHours(date, hours);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定小时数的时间
     *
     * @param currentDate 传入需要往后推的时间
     * @param hours       往后推的小时数
     * @return 返回传入的时间往后推一定小时数的时间
     */
    public static Date afterHours(Date currentDate, int hours) {
        if (currentDate == null || hours == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.HOUR_OF_DAY, hours);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往后推一定天数的时间
     *
     * @param timestamp  传入需要往后推的时间
     * @param hours      往后推的小时数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定天数的时间
     */
    public static Timestamp afterHours(Timestamp timestamp, int hours, String formatType) {
        if (timestamp == null || hours == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = afterHours(date, hours);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定分钟数的时间
     *
     * @param strTime    传入需要往后推的时间
     * @param minutes    往后推的分钟数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定分钟数的时间
     */
    public static String afterMinutes(String strTime, int minutes, String formatType) {
        if (StringUtils.isEmpty(strTime) || minutes == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = afterMinutes(date, minutes);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定分钟数的时间
     *
     * @param currentDate 传入需要往后推的时间
     * @param minutes     往后推的分钟数
     * @return 返回传入的时间往后推一定分钟数的时间
     */
    public static Date afterMinutes(Date currentDate, int minutes) {
        if (currentDate == null || minutes == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.MINUTE, minutes);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往后推一定分钟数的时间
     *
     * @param timestamp  传入需要往后推的时间
     * @param minutes    往后推的分钟数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定分钟数的时间
     */
    public static Timestamp afterMinutes(Timestamp timestamp, int minutes, String formatType) {
        if (timestamp == null || minutes == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = afterMinutes(date, minutes);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定秒数的时间
     *
     * @param strTime    传入需要往后推的时间
     * @param second     往后推的秒数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定秒数的时间
     */
    public static String afterSecond(String strTime, int second, String formatType) {
        if (StringUtils.isEmpty(strTime) || second == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = afterSecond(date, second);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往后推一定秒数的时间
     *
     * @param currentDate 传入需要往后推的时间
     * @param second      往后推的秒数
     * @return 返回传入的时间往后推一定秒数的时间
     */
    public static Date afterSecond(Date currentDate, int second) {
        if (currentDate == null || second == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.SECOND, second);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往后推一定秒数的时间
     *
     * @param timestamp  传入需要往后推的时间
     * @param second     往后推的秒数
     * @param formatType 时间格式
     * @return 返回传入的时间往后推一定秒数的时间
     */
    public static Timestamp afterSecond(Timestamp timestamp, int second, String formatType) {
        if (timestamp == null || second == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = afterSecond(date, second);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定年数的时间
     *
     * @param strTime    传入需要往前推的时间
     * @param year       往前推的年份
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定年数的时间
     */
    public static String beforeYear(String strTime, int year, String formatType) {
        if (StringUtils.isEmpty(strTime) || year == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = beforeYear(date, year);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定年数的时间
     *
     * @param currentDate 传入需要往前推的时间
     * @param year        往前推的年份
     * @return 返回传入的时间往前推一定年数的时间
     */
    public static Date beforeYear(Date currentDate, int year) {
        if (currentDate == null || year == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.YEAR, -year);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往前推一定年数的时间
     *
     * @param timestamp  传入需要往前推的时间
     * @param year       往前推的年份
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定年数的时间
     */
    public static Timestamp beforeYear(Timestamp timestamp, int year, String formatType) {
        if (timestamp == null || year == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = beforeYear(date, year);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定月数的时间
     *
     * @param strTime    传入需要往前推的时间
     * @param month      往前推的月份
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定月数的时间
     */
    public static String beforeMonth(String strTime, int month, String formatType) {
        if (StringUtils.isEmpty(strTime) || month == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = beforeMonth(date, month);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定月数的时间
     *
     * @param currentDate 传入需要往前推的时间
     * @param month       往前推的月份
     * @return 返回传入的时间往前推一定月数的时间
     */
    public static Date beforeMonth(Date currentDate, int month) {
        if (currentDate == null || month == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.MONTH, -month);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往前推一定月数的时间
     *
     * @param timestamp  传入需要往前推的时间
     * @param month      往前推的月份
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定月数的时间
     */
    public static Timestamp beforeMonth(Timestamp timestamp, int month, String formatType) {
        if (timestamp == null || month == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = beforeMonth(date, month);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定周数(一年中的第几周)的时间
     *
     * @param strTime    传入需要往前推的时间
     * @param week       往前推的周数(一年中的第几周)
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定周数(一年中的第几周)的时间
     */
    public static String beforeWeek(String strTime, int week, String formatType) {
        if (StringUtils.isEmpty(strTime) || week == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = beforeWeek(date, week);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定周数(一年中的第几周)的时间
     *
     * @param currentDate 传入需要往前推的时间
     * @param week        往前推的周数(一年中的第几周)
     * @return 返回传入的时间往前推一定周数(一年中的第几周)的时间
     */
    public static Date beforeWeek(Date currentDate, int week) {
        if (currentDate == null || week == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.WEEK_OF_YEAR, -week);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往前推一定周数(一年中的第几周)的时间
     *
     * @param timestamp  传入需要往前推的时间
     * @param week       往前推的周数(一年中的第几周)
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定周数(一年中的第几周)的时间
     */
    public static Timestamp beforeWeek(Timestamp timestamp, int week, String formatType) {
        if (timestamp == null || week == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = beforeWeek(date, week);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定周数(一月中的第几周)的时间
     *
     * @param strTime    传入需要往前推的时间
     * @param week       往前推的周数(一月中的第几周)
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定周数(一月中的第几周)的时间
     */
    public static String beforeWeekOfMonth(String strTime, int week, String formatType) {
        if (StringUtils.isEmpty(strTime) || week == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = beforeWeekOfMonth(date, week);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定周数(一月中的第几周)的时间
     *
     * @param currentDate 传入需要往前推的时间
     * @param week        往前推的周数(一月中的第几周)
     * @return 返回传入的时间往前推一定周数(一月中的第几周)的时间
     */
    public static Date beforeWeekOfMonth(Date currentDate, int week) {
        if (currentDate == null || week == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.WEEK_OF_MONTH, -week);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往前推一定周数(一月中的第几周)的时间
     *
     * @param timestamp  传入需要往前推的时间
     * @param week       往前推的周数(一月中的第几周)
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定周数(一月中的第几周)的时间
     */
    public static Timestamp beforeWeekOfMonth(Timestamp timestamp, int week, String formatType) {
        if (timestamp == null || week == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = beforeWeekOfMonth(date, week);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定天数的时间
     *
     * @param strTime    传入需要往前推的时间
     * @param days       往前推的天数
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定天数的时间
     */
    public static String beforeDay(String strTime, int days, String formatType) {
        if (StringUtils.isEmpty(strTime) || days == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = beforeDay(date, days);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定天数的时间
     *
     * @param currentDate 传入需要往前推的时间
     * @param days        往前推的天数
     * @return 返回传入的时间往前推一定天数的时间
     */
    public static Date beforeDay(Date currentDate, int days) {
        if (currentDate == null || days == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.DATE, -days);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往前推一定天数的时间
     *
     * @param timestamp  传入需要往前推的时间
     * @param days       往前推的天数
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定天数的时间
     */
    public static Timestamp beforeDay(Timestamp timestamp, int days, String formatType) {
        if (timestamp == null || days == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = beforeDay(date, days);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定小时数的时间
     *
     * @param strTime    传入需要往前推的时间
     * @param hours      往前推的小时数
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定小时数的时间
     */
    public static String beforeHours(String strTime, int hours, String formatType) {
        if (StringUtils.isEmpty(strTime) || hours == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = beforeHours(date, hours);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定小时数的时间
     *
     * @param currentDate 传入需要往前推的时间
     * @param hours       往前推的小时数
     * @return 返回传入的时间往前推一定小时数的时间
     */
    public static Date beforeHours(Date currentDate, int hours) {
        if (currentDate == null || hours == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.HOUR_OF_DAY, -hours);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往前推一定小时数的时间
     *
     * @param timestamp  传入需要往前推的时间
     * @param hours      往前推的小时数
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定小时数的时间
     */
    public static Timestamp beforeHours(Timestamp timestamp, int hours, String formatType) {
        if (timestamp == null || hours == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = beforeHours(date, hours);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定分钟数的时间
     *
     * @param strTime    传入需要往前推的时间
     * @param minutes    往前推的分钟数
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定分钟数的时间
     */
    public static String beforeMinutes(String strTime, int minutes, String formatType) {
        if (StringUtils.isEmpty(strTime) || minutes == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = beforeMinutes(date, minutes);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定分钟数的时间
     *
     * @param currentDate 传入需要往前推的时间
     * @param minutes     往前推的分钟数
     * @return 返回传入的时间往前推一定分钟数的时间
     */
    public static Date beforeMinutes(Date currentDate, int minutes) {
        if (currentDate == null || minutes == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.MINUTE, -minutes);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往前推一定分钟数的时间
     *
     * @param timestamp  传入需要往前推的时间
     * @param minutes    往前推的分钟数
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定分钟数的时间
     */
    public static Timestamp beforeMinutes(Timestamp timestamp, int minutes, String formatType) {
        if (timestamp == null || minutes == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = beforeMinutes(date, minutes);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定秒数的时间
     *
     * @param strTime    传入需要往前推的时间
     * @param second     往前推的秒数
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定秒数的时间
     */
    public static String beforeSecond(String strTime, int second, String formatType) {
        if (StringUtils.isEmpty(strTime) || second == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = stringToDate(strTime, formatType);
        Date newDate = beforeSecond(date, second);
        return dateToString(newDate, formatType);
    }

    /**
     * 获取传入的时间往前推一定秒数的时间
     *
     * @param currentDate 传入需要往前推的时间
     * @param second      往前推的秒数
     * @return 返回传入的时间往前推一定秒数的时间
     */
    public static Date beforeSecond(Date currentDate, int second) {
        if (currentDate == null || second == 0) {
            return null;
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.SECOND, -second);
        return cal.getTime();
    }

    /**
     * 获取传入的时间往前推一定秒数的时间
     *
     * @param timestamp  传入需要往前推的时间
     * @param second     往前推的秒数
     * @param formatType 时间格式
     * @return 返回传入的时间往前推一定秒数的时间
     */
    public static Timestamp beforeSecond(Timestamp timestamp, int second, String formatType) {
        if (timestamp == null || second == 0 || StringUtils.isEmpty(formatType)) {
            return null;
        }
        Date date = timestampToDate(timestamp);
        Date newDate = beforeSecond(date, second);
        return dateToTimestamp(newDate, formatType);
    }

    /**
     * 获取年+年积日(日期转换得到年积日)
     *
     * @param year  年份
     * @param month 月份
     * @param date  日期
     * @return 返回年+年积日(一年中的第几天)
     */
    public static String getDay(int year, int month, int date) {
        if (year == 0 || month == 0 || date == 0) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, date);
        int days = cal.get(Calendar.DAY_OF_YEAR);
        String resultDays = "";
        int number10 = 10;
        int number100 = 100;
        if (days >= number100) {
            resultDays = "" + days;
        } else if (days >= number10 && days < number100) {
            resultDays = "0" + days;
        } else if (days >= 0 && days < number10) {
            resultDays = "00" + days;
        }
        return year + resultDays;
    }

    /**
     * 获取年积日(日期转换为年积日)
     *
     * @param strTime    要转换的时间
     * @param formatType 时间格式
     * @return 返回年积日(一年中的第几天)
     */
    public static int getDays(String strTime, String formatType) {
        if (StringUtils.isEmpty(strTime) || StringUtils.isEmpty(formatType)) {
            return -1;
        }
        try {
            DateFormat formater = new SimpleDateFormat(formatType);
            Date date = formater.parse(strTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int days = cal.get(Calendar.DAY_OF_YEAR);
            return days;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获取年月日(年积日转年月日)
     *
     * @param dataString 要转换的时间
     * @return 返回年月日(年积日转年月日)
     */
    public static String dataSwitch(String dataString) {
        if (StringUtils.isEmpty(dataString)) {
            return null;
        }
        String year = dataString.substring(0, 4);
        String beginData = year + "-01-01";
        long milliseconds = stringToLong(beginData, "yyyy-MM-dd");
        long days = Integer.parseInt(dataString.substring(4, 7)) - 1;
        long countseconds = milliseconds + days * 24 * 3600 * 1000;
        return longToString(countseconds, "yyyy-MM-dd");
    }

    /**
     * 获取年份的数组
     *
     * @param beginYear 起始年份
     * @param endYear   结束年份
     * @return 年份的数组
     */
    public static String[] getYearArray(int beginYear, int endYear) {
        String[] yearArray = new String[endYear - beginYear + 1];
        for (int i = beginYear; i <= endYear; i++) {
            yearArray[i - beginYear] = String.valueOf(i);
        }
        return yearArray;
    }

    /**
     * 获取年份的数组
     *
     * @param beginYear 起始年份
     * @return 年份的数组
     */
    public static String[] getYearArray(int beginYear) {
        return getYearArray(beginYear, 2099);
    }

    /**
     * 获取年份的数组
     *
     * @return 年份的数组
     */
    public static String[] getYearArray() {
        return getYearArray(1900);
    }

    /**
     * 获取星期
     *
     * @param timestamp 时间
     * @return 星期
     */
    public static int getWeek(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        Date date = timestampToDate(timestamp);
        calendar.setTime(date);
        return getWeek(calendar);
    }

    /**
     * 获取星期
     *
     * @param strTime    时间
     * @param formatType 时间格式
     * @return 星期
     */
    public static int getWeek(String strTime, String formatType) {
        Calendar calendar = Calendar.getInstance();
        Date date = stringToDate(strTime, formatType);
        calendar.setTime(date);
        return getWeek(calendar);
    }

    /**
     * 获取星期
     *
     * @param time 时间
     * @return 星期
     */
    public static int getWeek(long time) {
        Calendar calendar = Calendar.getInstance();
        Date date = longToDate(time, DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode());
        calendar.setTime(date);
        return getWeek(calendar);
    }

    /**
     * 获取星期
     *
     * @param date 时间
     * @return 星期
     */
    public static int getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getWeek(calendar);
    }

    /**
     * 获取星期
     *
     * @param calendar 当前时间
     * @return 星期
     */
    public static int getWeek(Calendar calendar) {
        int week = 0;
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                week = 7;
                break;
            case 2:
                week = 1;
                break;
            case 3:
                week = 2;
                break;
            case 4:
                week = 3;
                break;
            case 5:
                week = 4;
                break;
            case 6:
                week = 5;
                break;
            case 7:
                week = 6;
                break;
            default:
                week = 0;
                break;
        }
        if (week == 0) {
            throw new CommonException("获取星期失败！");
        }
        return week;
    }

    /**
     * 获取星期
     *
     * @param timestamp 时间
     * @return 星期
     */
    public static String getWeekChineseName(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        Date date = timestampToDate(timestamp);
        calendar.setTime(date);
        return getWeekChineseName(calendar);
    }

    /**
     * 获取星期
     *
     * @param strTime    时间
     * @param formatType 时间格式
     * @return 星期
     */
    public static String getWeekChineseName(String strTime, String formatType) {
        Calendar calendar = Calendar.getInstance();
        Date date = stringToDate(strTime, formatType);
        calendar.setTime(date);
        return getWeekChineseName(calendar);
    }

    /**
     * 获取星期
     *
     * @param time 时间
     * @return 星期
     */
    public static String getWeekChineseName(long time) {
        Calendar calendar = Calendar.getInstance();
        Date date = longToDate(time, DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode());
        calendar.setTime(date);
        return getWeekChineseName(calendar);
    }

    /**
     * 获取星期
     *
     * @param date 时间
     * @return 星期
     */
    public static String getWeekChineseName(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getWeekChineseName(calendar);
    }

    /**
     * 获取星期的中文
     *
     * @param calendar 当前时间
     * @return 星期
     */
    public static String getWeekChineseName(Calendar calendar) {
        String result = "";
        int week = getWeek(calendar);
        switch (week) {
            case 1:
                result = "星期一";
                break;
            case 2:
                result = "星期二";
                break;
            case 3:
                result = "星期三";
                break;
            case 4:
                result = "星期四";
                break;
            case 5:
                result = "星期五";
                break;
            case 6:
                result = "星期六";
                break;
            case 7:
                result = "星期日";
                break;
            default:
                break;
        }
        if (StringUtils.isEmpty(result)) {
            throw new CommonException("获取星期失败！");
        }
        return result;
    }

    /**
     * 获取时间格式列表
     *
     * @return 时间格式列表
     */
    public static List<CodeNameDTO> getDateTimeFormatList() {
        List<String> formatList = new ArrayList<String>();
        formatList.add(DateTimeEnum.YYYY_MM_DDHH_MM_SS.getCode());
        formatList.add(DateTimeEnum.YYYY_MM_DDHH_MM.getCode());
        formatList.add(DateTimeEnum.YYYY_MM_DDHH.getCode());
        formatList.add(DateTimeEnum.YYYY_MM_DD.getCode());
        formatList.add(DateTimeEnum.YYYY_MM.getCode());
        formatList.add(DateTimeEnum.YYYY.getCode());
        formatList.add(DateTimeEnum.YYYY_NAME_MM_NAME_DDHH_NAME_MM_NAME_SS.getCode());
        formatList.add(DateTimeEnum.YYYY_NAME_MM_NAME_DDHH_NAME_MM.getCode());
        formatList.add(DateTimeEnum.YYYY_NAME_MM_NAME_DDHH.getCode());
        formatList.add(DateTimeEnum.YYYY_NAME_MM_NAME_DD.getCode());
        formatList.add(DateTimeEnum.YYYY_NAME_MM.getCode());
        formatList.add(DateTimeEnum.YYYY_NAME.getCode());
        formatList.add(DateTimeEnum.YYYY_1_MM_1_DDHH_1_MM_1_SS.getCode());
        formatList.add(DateTimeEnum.YYYY_1_MM_1_DDHH_1_MM.getCode());
        formatList.add(DateTimeEnum.YYYY_1_MM_1_DDHH.getCode());
        formatList.add(DateTimeEnum.YYYY_1_MM_1_DD.getCode());
        formatList.add(DateTimeEnum.YYYY_1_MM.getCode());
        formatList.add(DateTimeEnum.YYYYMMDDHHMMSS.getCode());
        formatList.add(DateTimeEnum.YYYYMMDDHHMM.getCode());
        formatList.add(DateTimeEnum.YYYYMMDDHH.getCode());
        formatList.add(DateTimeEnum.YYYYMMDD.getCode());
        formatList.add(DateTimeEnum.YYYYMM.getCode());

        int length = formatList.size();
        List<CodeNameDTO> dateTimeFormatList = new ArrayList<>(length);
        for (int index = 0; index < length; index++) {
            String format = formatList.get(index);
            CodeNameDTO codeNameDTO = new CodeNameDTO();
            codeNameDTO.setCode(format).setName(format);
            dateTimeFormatList.add(codeNameDTO);
        }
        return dateTimeFormatList;
    }

}
