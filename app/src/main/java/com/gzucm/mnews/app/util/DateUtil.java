package com.gzucm.mnews.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created on 2018/6/28 0028 16:30.
 *
 * @author herozii
 */
public class DateUtil {


    public static ArrayList<String> getSevenDate(int intervals) {
        ArrayList<String> fetureDaysList = new ArrayList<>();
        for (int i = 0; i <intervals; i++) {
            fetureDaysList.add(getFetureDate(i));
        }
        return fetureDaysList;
    }



    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    public static ArrayList<String> getWeek(List<String> datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        List<String> week = new ArrayList<>();
        for(int i = 0;i < datetime.size();i++){
            try {
                datet = f.parse(datetime.get(i));
                cal.setTime(datet);
                int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
                if (w < 0){
                    w = 0;
                }
                String day = weekDays[w];
                week.add(day);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return (ArrayList<String>) week;
    }

    public static ArrayList<String> getSeven(List<String> dates) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        ArrayList<String> serven = new ArrayList<>();
        for(int i = 0;i < dates.size();i++){
            Date date = StrToDate(dates.get(i));
            String now = simpleDateFormat.format(date);
            serven.add(now);
        }
        return serven;
    }

    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
