package com.amir.api.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApi {
	
	//list object fetching by stream ..
	public static void main(String[] args) {
		
		List<String> nameList = Arrays.asList("rizvi","amir","fema");
		System.out.println(nameList);
		
		//iterating by function interface.
		//nameList.forEach(name->System.out.println(name));
		
		//sorting by function interface.(Comparator)
		//nameList.sort((first,second)->{return first.compareTo(second);});
		//System.out.println(nameList);
		
		//filtering using Predicate function interface.
		Predicate<String> pre = name-> {return name.contains("m");};
		List<String> filterName = nameList.stream().filter(pre).collect(Collectors.toList());
		System.out.println(filterName);
		
		//sorted using sorted method of stream.
		List<String> sortedList = nameList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		List<String> sortedListUsingComparator = nameList.stream()
				.sorted((name1,name2)->name2.compareTo(name1))
				.collect(Collectors.toList());
		System.out.println(sortedListUsingComparator);
	
		//using map method to create new list of same size.
		List<String> mapStream = nameList.stream().map(name->name.toUpperCase()).collect(Collectors.toList());
		System.out.println(mapStream);
		
		System.out.println("OriginalList"+nameList);
		
				
	}

}
