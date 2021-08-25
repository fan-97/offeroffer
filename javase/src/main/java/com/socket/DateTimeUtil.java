package com.socket;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Faster
 * @date 2020/3/8 11:22
 */
public class DateTimeUtil {
    public static String dateFormatter(Date date,String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static String dateFormatter(Date date){
        return dateFormatter(date,"yyyy-MM-dd hh:mm:ss");
    }
}
