package com.ibm.dsw.pricepub.admin.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class DateUtil {

    public static int getYear(String startDate){
        int year = 0;
        if(StringUtils.isNotBlank(startDate) && startDate.length()>10){
            year = Integer.parseInt(startDate.substring(0,4));
        }

        return year;

    }

    public static int getMonth(String startDate){
        int month = 0;
        if(StringUtils.isNotBlank(startDate) && startDate.length()>10){
            month = Integer.parseInt(startDate.substring(5,7));
        }

        return month;
    }

    public static int getDay(String startDate){
        int day = 0;
        if(StringUtils.isNotBlank(startDate) && startDate.length()>10){
            day = Integer.parseInt(startDate.substring(8,10));
        }

        return day;
    }
    public static int getHour(String startDate){

        int hour = 0;
        if(StringUtils.isNotBlank(startDate) && startDate.length()>10){
            hour = Integer.parseInt(startDate.substring(11,13));
        }

        return hour;
    }

    public static int getMin(String startDate){
        int min = 0;
        if(StringUtils.isNotBlank(startDate) && startDate.length()>10){
            min = Integer.parseInt(startDate.substring(14,16));
        }

        return min;
    }

    public static int getSec(String startDate){
        int sec = 0;
        if(StringUtils.isNotBlank(startDate) && startDate.length()>10){
            sec = Integer.parseInt(startDate.substring(17,19));
        }

        return sec;
    }


}
