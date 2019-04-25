package com.amir.api;

import java.util.function.Function;
import java.util.function.Predicate;

//inbuild functional interface example.(in java.util.function)  
public class FIApi {

	public static void main(String[] args) {
		
	//Predicate FI---checking True for male false for others
		Predicate<String> pre = gender-> {return "Male".equalsIgnoreCase(gender);};
		
		System.out.println(pre.test("Male"));
		System.out.println(pre.test("Female"));
		
	//Functions FI ----just converting integer to string.
		Function<Integer, String> func = input->{return String.valueOf(input);};
		String num = func.apply(123456);
		System.out.println(num);
		
		
}
}