package com.learn.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * JDK8 Time与UTIL包日期时间转换
 * @author yuanjin
 * @date 2019年4月10日 上午10:09:50
 */
public class LocalDateUtil {
	
	public static void main(String[] args) {
		System.out.println(dateToLocalDateTime(new Date()));
		System.out.println(dateToLocalDate(new Date()));
		System.out.println(dateToLocalTime(new Date()));
		System.out.println(localDateTimeToDate(LocalDateTime.now()));
		System.out.println(localDateToDate(LocalDate.now()));
		System.out.println(localTimeToDate(LocalDate.now(),LocalTime.now()));
	}
	
	
	/**
	 * Date转LocalDateTime
	 * @param date
	 * @return
	 */
	public static LocalDateTime dateToLocalDateTime(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		return localDateTime;
	}

	/**
	 * Date转LocalDate
	 * @param date
	 * @return
	 */
	public static LocalDate dateToLocalDate(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		LocalDate localDate = localDateTime.toLocalDate();
		return localDate;
	}

	/**
	 * Date转LocalTime
	 * @param date
	 * @return
	 */
	public static LocalTime dateToLocalTime(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		LocalTime localTime = localDateTime.toLocalTime();
		return localTime;
	}

	/**
	 * LocalDateTime转Date
	 * @param localDateTime
	 * @return
	 */
	public static Date localDateTimeToDate(LocalDateTime localDateTime) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zone).toInstant();
		java.util.Date date = Date.from(instant);
		return date;
	}

	/**
	 * LocalDate转Date
	 * @param localDate
	 * @return
	 */
	public static Date localDateToDate(LocalDate localDate) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
		java.util.Date date = Date.from(instant);
		return date;
	}

	/**
	 * LocalTime转Date
	 */
	public static Date localTimeToDate(LocalDate localDate,LocalTime localTime) {
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zone).toInstant();
		java.util.Date date = Date.from(instant);
		return date;
	}
}
