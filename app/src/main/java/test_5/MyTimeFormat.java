package test_5;

import androidx.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTimeFormat {
    //拼接并格式化时间 HH:mm:ss
    public static String timeFormat(int hour, int minute, int second) {
        if (hour > 23 || hour < 0 || minute > 59 || minute < 0 || second > 59 || second < 0) {
            return null;
        }
        String result;
        String strHour = String.valueOf(hour);
        String strMinute = String.valueOf(minute);
        String strSecond = String.valueOf(second);
        if (hour < 10) {
            strHour = "0" + strHour;
        }
        if (minute < 10) {
            strMinute = "0" + strMinute;
        }
        if (second < 10) {
            strSecond = "0" + strSecond;
        }
        result = strHour + ":" + strMinute + ":" + strSecond;
        return result;
    }
    // 拼接并格式化时间 HH:mm
    public static String timeFormat(int hour, int minute) {
        if (hour > 23 || hour < 0 || minute > 59 || minute < 0) {
            return null;
        }
        String result;
        String strHour = String.valueOf(hour);
        String strMinute = String.valueOf(minute);
        if (hour < 10) {
            strHour = "0" + strHour;
        }
        if (minute < 10) {
            strMinute = "0" + strMinute;
        }
        result = strHour + ":" + strMinute;
        return result;
    }
    //日期转字符串
    public static String myDateFormat(Date date, @Nullable DateFormat dateFormatType) {

        SimpleDateFormat dateFormat;
        if (dateFormatType == null) {

            dateFormatType = DateFormat.NORMAL_TIME;
        }

        switch (dateFormatType) {
            case NORMAL_TIME:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
            case REMOVE_YEAR_TIME:
                dateFormat = new SimpleDateFormat("MM-dd HH:mm");
                break;
            case NORMAL_DATE:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case REMOVE_YEAR_DATE:
                dateFormat = new SimpleDateFormat("MM-dd");
                break;
            case SPECIAL_TYPE:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
                break;
            default:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
        }

        return dateFormat.format(date);
    }
    //字符串转日期
    public static Date myDateFormat(String str, @Nullable DateFormat dateFormatType) {
        SimpleDateFormat dateFormat;
        if (dateFormatType == null) {
            dateFormatType = DateFormat.NORMAL_TIME;
        }
        switch (dateFormatType) {
            case NORMAL_TIME:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
            case REMOVE_YEAR_TIME:
                dateFormat = new SimpleDateFormat("MM-dd HH:mm");
                break;
            case NORMAL_DATE:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case REMOVE_YEAR_DATE:
                dateFormat = new SimpleDateFormat("MM-dd");
                break;
            case SPECIAL_TYPE:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
                break;
            default:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
        }
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }
    //字符串转日期
    public static Date myDateFormat(Integer year,
                                    Integer month,
                                    Integer day,
                                    Integer hour,
                                    Integer minute,
                                    @Nullable DateFormat dateFormatType) {
        SimpleDateFormat dateFormat;
        String str;
        if (dateFormatType == null) {
            dateFormatType = DateFormat.NORMAL_TIME;
        }
        switch (dateFormatType) {
            case NORMAL_TIME:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                str = year + "-" + month + "-" + day + " " + hour + ":" + minute;
                break;
            case REMOVE_YEAR_TIME:
                dateFormat = new SimpleDateFormat("MM-dd HH:mm");
                str = month + "-" + day + " " + hour + ":" + minute;
                break;
            case NORMAL_DATE:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                str = year + "-" + month + "-" + day;
                break;
            case REMOVE_YEAR_DATE:
                dateFormat = new SimpleDateFormat("MM-dd");
                str = month + "-" + day;
                break;
            case SPECIAL_TYPE:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
                str = year + "-" + month + "-" + day + "-" + hour + "-" + minute;
                break;
            default:
                dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                str = year + "-" + month + "-" + day + " " + hour + ":" + minute;
                break;
        }
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            return null;
        }
    }
    //得到时间字符串，判断是否去除年份
    //去除规则，如果年份是当年
    public static String getTimeStr(Date date) {
        int nowYear = new MyTimeGetter(new Date(System.currentTimeMillis())).getYear();
        int targetYear = new MyTimeGetter(date).getYear();
        if (nowYear == targetYear) {
            //  去除年份
            return myDateFormat(date, DateFormat.REMOVE_YEAR_TIME);
        }
        return myDateFormat(date, DateFormat.NORMAL_TIME);
    }


}
