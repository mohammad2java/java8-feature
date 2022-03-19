package com.amir.api.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Date2TimeDemo {

	/* 
	 * core concept behind date data type in java
	 * ---------------------------------------------
	 * before time api(package) there there was 2 classes to deal with date.
	1) java.util.Date (1.0)    (dont confuse with java.sql.Date --> this for jdbc api)
	2) java.util.Calendar(1.1)
	
	=> why calender having many useful method with date--adding/substracting year/month/second 
	  can be get Date object from calendar using getTime and also can set using setTime.
	=> Date & Calendar is mutable object ( which is bad)
	=> Calendar.getInstance(); return object of java.util.GregorianCalendar
	=> Calendar & Date work with system-timezone, it cant work with specified timezone.even if Calendar have argument to pass timezone.
	  you have only one way to work with timezone ,you have set system-timezone as target one.
	  TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Asia/Manila")));
	  time-package api happlily working with specified TimeZone.
	
	  SimpleDateFormat we used for lagecy with java.util.Date
	  
	
	
	 Time API
	 -------------
	 LocalDate  -> deals with date only
	 LocalTime  -> deals with time only 
	 LocalDateTime -> Date+Time 
	 ZonedDateTime  -> date+time+zone --> best alernative for java.util.Date & Calendar
	 Instant  --> available as bridge between date/calendar <-> ZonedDateTime  --> always used UTC timezone
	
	 you can get Date object from TimeAPI using toInstant and vice versa.
	 	
	 Instant is availabe in Date,Calendar & Time API also.
	* alternative for SimpleDateFormat is DateTimeFormatter.
	* 
	* you can use format method of time api or format method of DateTimeFormatter class.
	* 
	*
	*/
	
	
	
	public static void main(String[] args) {
		
		TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Asia/Manila")));
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(now);
		//ZonedDateTime addedOne = now.plusHours(2);
		
		String format = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(now);
		System.out.println(now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
		
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		System.out.println(now.format(dtf));
		
		LocalDate date = LocalDate.now();
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		  String text = "2022-03-19";
		  LocalDate parsedDate = LocalDate.parse(text, formatter);
		  System.out.println(parsedDate);
		
	}
}
