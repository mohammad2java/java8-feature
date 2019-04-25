package com.amir.intf;

//writing annotation is optional but you have written you can add more than one abstract method you will get CE.
//example --Invalid '@FunctionalInterface' annotation; Greeting is not a functional interface
@FunctionalInterface
public interface Greeting {
	
	int MY_AGE=30;
	String MY_NAME="Amir";
	
	 void greet();
	
	 //this is the defender method.....if you want to expand any existing interface..then default method is the way to defend the other lib that are using this exiting interface.
	   default void findMyName() {
		 System.out.println(MY_NAME);
	 }
	  
	   ///static method is one type of helper method to functional interface just to provide code reusibility and avoid duplicacy of code.
	 public static void findMyAge() {
		 System.out.println(MY_AGE);
	  }
	

}
