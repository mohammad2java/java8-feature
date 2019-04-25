package com.amir.api;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JodaDateApi {
	public static void main(String[] args) {
		
		//how to create LocalDateTimeObject.
		//using now()
		LocalDateTime ldt = LocalDateTime.now();
		Date date = new Date();
		System.out.println(ldt);
		//default format:2018-07-22T20:12:19.688
		System.out.println(date);
		//default format: Sun Jul 22 20:12:19 IST 2018
		LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("GMT+05:30"));
		//Getting date using Zone Wise.
		//ZoneId.of("GMT+05:30") || ZoneId.of("+05:30") || ZoneId.of("UTC+05:30") all are same ...you can use anyOne
		//format of zondId is Imp else throw error..format::+hh:mm or -hh:mm  you know for India it is +05:30 
		 System.out.println(ldt2);
		//convert Date to LocalDateTime..
		 LocalDateTime ldt3 = Instant.ofEpochMilli(date.getTime())
				 .atZone(ZoneId.systemDefault())
				 .toLocalDateTime();
		 
		System.out.println(ldt3);		
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
	
	}

}
