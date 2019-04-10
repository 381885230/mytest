package com.learn.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class LocalDateTest {

    public static void main(String[] args) {
    	LocalDate ld=dateToLocalDate();
        System.out.println("LocalDate = " + ld);
    }
    
    /**
     * Date转LocalDate
     * @return
     */
    public static LocalDate dateToLocalDate(){
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }
    
    /**
     * LocalDate转Date
     * @return
     */
    public static Date localDateToDate(){
    	 ZoneId zoneId = ZoneId.systemDefault();
         LocalDate localDate = LocalDate.now();
         ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
         Date date = Date.from(zdt.toInstant());
         return date;
    }
    
}
