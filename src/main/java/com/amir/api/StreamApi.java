package com.amir.api;

import java.util.Arrays;
import java.util.List;

public class StreamApi {
	
	//list object fetching by stream ..
	public static void main(String[] args) {
		
		List<String> nameList = Arrays.asList("rizvi","amir","fema");
		System.out.println(nameList);
		//iterating by function interface.
		nameList.forEach(name->System.out.println(name));
		//sorting by function interface.
		nameList.sort((first,second)->{return first.compareTo(second);});
		System.out.println(nameList);
	}

}
