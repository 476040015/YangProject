package com.example.work.utils.date;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期格式的常量类
 *
 * @author chiyan
 */

public abstract class DateFormatSample {


    /**
     * 1.时间格式
     */
    public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";// 年-月-日
    public static final String DATE_FORMAT_YMDHM = "yyyy-MM-dd HH:mm";// 年-月-日 时:分
    public static final String DATE_FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";// 年-月-日 时:分:秒
    public static final String DATE_FORMAT_YMD_NO_BLANK = "yyyyMMdd"; // 年月日
    public static final String DATE_FORMAT_YMDHMS_NO_BLANK = "yyyyMMddHHmmss"; // 年月日时分秒
    public static final String DATE_FORMAT_YMD_SLASH = "yyyy/MM/dd";// 年/月/日
    public static final String DATE_FORMAT_YMDHMS_SLASH = "yyyy/MM/dd HH:mm:ss";// 年/月/日 时:分:秒
    public static final String DATE_FORMAT_YM_NO_BLANK = "yyyyMM"; // 年月
    public static final String DATE_FORMAT_YM = "yyyy-MM";// 年-月

    /**
     * 2.时间格式
     */
    public static final DateFormat DATEFORMAT_YMD = new SimpleDateFormat(DATE_FORMAT_YMD);// 年-月-日
    public static final DateFormat DATEFORMAT_YMDHM = new SimpleDateFormat(DATE_FORMAT_YMDHM);// 年-月-日 时:分
    public static final DateFormat DATEFORMAT_YMDHMS = new SimpleDateFormat(DATE_FORMAT_YMDHMS);// 年-月-日 时:分:秒
    public static final DateFormat DATEFORMAT_YMD_NO_BLANK = new SimpleDateFormat(DATE_FORMAT_YMD_NO_BLANK);// 年月日
    public static final DateFormat DATEFORMAT_YMDHMS_NO_BLANK = new SimpleDateFormat(DATE_FORMAT_YMDHMS_NO_BLANK); // 年月日时分秒
    public static final DateFormat DATEFORMAT_YMD_SLASH = new SimpleDateFormat(DATE_FORMAT_YMD_SLASH);// 年/月/日
    public static final DateFormat DATEFORMAT_YMDHMS_SLASH = new SimpleDateFormat(DATE_FORMAT_YMDHMS_SLASH); // 年/月/日
    // 时:分:秒

    // ----------------------------------------TIME定义--------------------------------------

    public static final String BeginHour = "00:00:00";

    public static final String EndHour = " 59:59:59";

    /**
     * 格式化时间成"yyyy-MM-dd HH-mm-ss"字符串形式
     *
     * @param time
     * @return
     */
    public static String formatDateTime(Date time) {
        if (time == null) {
            return null;
        }

        return DATEFORMAT_YMDHMS.format(time);
    }

    /**
     * 格式化日期成"yyyy-MM-dd"形式
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return DATEFORMAT_YMD.format(date);
    }
    /**
     * 格式化日期成"yyyy-MM-dd"形式
     *
     * @param date
     * @return
     */
    public static String formatDateWithM(Date date) {
        if (date == null) {
            return null;
        }
        return DATEFORMAT_YMDHM.format(date);
    }

    public static Date transferString2Date(String s, DateFormat format){
    	try {
            return format.parse(s);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 格式化时间成"yyyy-MM-dd HH-mm-ss"字符串形式
     *
     * @param time
     * @return
     */
    public static String formatNextDateTime(Date time) {
        if (time == null) {
            return null;
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(time);
        // 把日期往后增加一天,整数  往后推,负数往前移动
        calendar.add(Calendar.DATE, 1);
        // 这个时间就是日期往后推一天的结果
        time = calendar.getTime();

        return DATEFORMAT_YMDHMS.format(time);
    }

    public static String addStringDay(String date){
        if(StringUtils.isEmpty(date)){
            return date;
        }
        Date preDate = null;
        try {
            preDate =  DATEFORMAT_YMD.parse(date);
        }catch (Exception e){
            return null;
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(preDate);
        // 把日期往后增加一天,整数  往后推,负数往前移动
        calendar.add(Calendar.DATE, 1);
        // 这个时间就是日期往后推一天的结果
        preDate = calendar.getTime();
        return DATEFORMAT_YMD.format(preDate);
    }

    public static String addStringDay(String date,int days){
        if(StringUtils.isEmpty(date)){
            return date;
        }
        Date preDate = null;
        try {
            preDate =  DATEFORMAT_YMD.parse(date);
        }catch (Exception e){
            return null;
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(preDate);
        // 把日期往后增加一天,整数  往后推,负数往前移动
        calendar.add(Calendar.DATE, days);
        // 这个时间就是日期往后推一天的结果
        preDate = calendar.getTime();
        return DATEFORMAT_YMD.format(preDate);
    }

    public static String getCurrentDate(){
        return formatDate(new Date());
    }


}
