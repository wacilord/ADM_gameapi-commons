package com.icrown.gameapi.commons.utils;

import com.icrown.gameapi.commons.responses.ResponseCode;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Frank
 */
@Component
public class DateUtil {

    public static final String TIMEZONE_EST_NAME = "US/Eastern";
    public static final ZoneId TIMEZONE_EST = ZoneId.of(TIMEZONE_EST_NAME);

    /**
     * 格式化日期
     *
     * @param date
     * @param format
     * @return
     */
    public String getDateFormat(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public String getDateFormat(Date date, String format, TimeZone timeZone) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(timeZone);
        return sdf.format(date);
    }


    public Date getDateWithFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(getDateFormat(date, format));
        }
        catch (Exception ex) {
            throw new APIException(ResponseCode.GAMEAPI_DATETIME_FORMAT_ERROR);
        }
    }

    public Date strToDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        }
        catch (Exception ex) {
            throw new APIException(ResponseCode.GAMEAPI_DATETIME_FORMAT_ERROR);
        }
    }

    /**
     * 簡單格式化日期
     *
     * @param date
     * @return
     */
    public String getString(Date date) {
        return getDateFormat(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 時間加上時間
     *
     * @param date
     * @param amount
     * @return
     */
    public Date addTime(Date date, int unit, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(unit, amount);
        return cal.getTime();
    }

    /**
     * 取得兩個時間相差秒數
     *
     * @param date1
     * @param date2
     * @return
     */
    public long diffSeconds(Date date1, Date date2) {
        long diff = date2.getTime() - date1.getTime();
        return diff / 1000;
    }

    /**
     * 取得當前日期物件
     *
     * @return
     */
    public Date getDate() {
        return new Date();
    }

    /***
     * 取得 N天前的日期
     * @param days
     * @return
     */
    public String getPreviousDate(int days) {
        final LocalDateTime currentDateTime = LocalDateTime.now();
        final ZonedDateTime zonedCurrentDateTime = currentDateTime.atZone(TIMEZONE_EST);

        ZonedDateTime oldDate = zonedCurrentDateTime.plusDays(-days);
        DateTimeFormatter dateFromat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return oldDate.format(dateFromat);

    }

    /***
     * 取得 N天後的日期
     * @param days
     * @return
     */
    public String getForwardDate(int days) {
        final LocalDateTime currentDateTime = LocalDateTime.now();
        final ZonedDateTime zonedCurrentDateTime = currentDateTime.atZone(TIMEZONE_EST);

        ZonedDateTime newDate = zonedCurrentDateTime.plusDays(days);
        DateTimeFormatter dateFromat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return newDate.format(dateFromat);

    }

    /**
     * 只取得日期的部份
     *
     * @param date
     * @return
     */
    public Date getDatePart(Date date) {
        // Get Calendar object set to the date and time of the given Date object
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // Set time fields to zero
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        // Put it back in the Date object
        date = cal.getTime();
        return date;
    }

    /**
     * 回傳包含startDate與endDate的每日List，ex:{"2020-05-31 10:00:00","2020-06-01 00:00:00","2020-06-02 00:00:00","2020-06-02 22:00:00"}
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Date> getDateIntervalList(Date startDate, Date endDate) {
        List<Date> dateList = new ArrayList<>();
        dateList.add(startDate);
        Date dt = this.getDateWithFormat(startDate, "yyyy-MM-dd 00:00:00");
        dt = this.addTime(dt, Calendar.DATE, 1);
        while (dt.compareTo(endDate) < 0) {
            if (dt.compareTo(startDate) > 0) {
                dateList.add(dt);
            }
            dt = this.addTime(dt, Calendar.DATE, 1);
        }
        dateList.add(endDate);

        return dateList;
    }
}

