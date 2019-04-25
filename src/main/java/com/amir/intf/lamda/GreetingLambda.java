package com.amir.intf.lamda;

import com.amir.App;
import com.amir.intf.Greeting;
import com.amir.intf.SpecialGreeting;

public class GreetingLambda {
// lambda expression is syntactic sugar or shortest way of implementation of functional interface.
	//in place of lambda expression we have use anonymous classes.
	public static void main(String[] args) {
		//static function calling like we call in util classes.
		Greeting.findMyAge();
		//lambda expression for Greeting interface(Functional interface...annotation are optional)
		Greeting greeting0 = ()->System.out.println("LambdaExpression");
		//another way to write lambda expression with static methods.(basically use for code reusebility-avoid duplicate codes)
		Greeting greeting = Greeting::findMyAge;
		//another way to write lambda expression with instance method
		Greeting greeting2 = greeting::findMyName;
		
		greeting0.greet();
		greeting.greet();
		greeting2.greet();
		
		Greeting greeting3 = new Greeting() {
			
			@Override
			public void greet() {
				System.out.println("this is example of ananymous classes");
				
			}
		};
		
		greeting3.greet();
		//code reusebility with class static method
		Greeting greeting4 = ()->App.smile();
			greeting4.greet();
		//Some RND with Lamda Child interface.
		//=======================================
		//SpecialGreeting.findMyAge();CE static method will not inherited to child Interface(like class static method  does).
		SpecialGreeting sg = ()->System.out.println("Special greeting");
		sg.greet();
		sg.findMyName();
		
		
		

	}

}
