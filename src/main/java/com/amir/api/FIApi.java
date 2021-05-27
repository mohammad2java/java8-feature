package com.amir.api;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

//inbuild functional interface example.(in java.util.function)  
// 1) function.apply 2) predicate.test 3) supplier.get 4) consumer.accept
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
		

	// Supplier to Get Value withOut INPUT
		
		Supplier<Double> supplier  = Math::random;
		Stream<Double> dStreams = Stream.generate(supplier).limit(10);
		dStreams.forEach(System.out::println); //example of consumer
		
		
	//Consumer to accept the value
		
		//inbuild used
		
		//dStreams.map(function);
		//dStreams.filter(predicate)
		//dStreams.forEach(consumer);
		//Stream.generate(supplier)
		
}
}