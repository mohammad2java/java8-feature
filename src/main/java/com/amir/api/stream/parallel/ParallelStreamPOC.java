package com.amir.api.stream.parallel;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ParallelStreamPOC {
	 
	/*
	 * parallel streaming can be achieved via two way.
	 * 1) using parallel() of Stream
	 * 2) using parallelStream() of Collection Interface(its default method)
	 * internally it use forkjoin threadpool to manage all to run parallely using thread.
	 */
	
	
	public static void main(String[] args) {
		System.out.println("=================================");
		System.out.println("Using Sequential Stream");
		System.out.println("=================================");
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		IntStream intArrStream = Arrays.stream(array);
		intArrStream.forEach(s -> {
			System.out.println(s + " " + Thread.currentThread().getName());
		});
		System.out.println("=================================");
		System.out.println("Using Parallel Stream");
		System.out.println("=================================");
		IntStream intParallelStream = Arrays.stream(array).parallel();
		intParallelStream.forEach(s -> {
			System.out.println(s + " " + Thread.currentThread().getName());
		});
	}

	
	
}
