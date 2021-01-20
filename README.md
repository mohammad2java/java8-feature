This document describe complete project with new concept of java8.
-------------------------------------------------------------------------
	1-Interface new feature <br>
	2-Lambda Expression(->) <br>
	3-new Operator(::) <br>
	4-Java8 API--Stream & date & functinalInterface <br>
	5-Optional class <br>
	6-forEach


Interface New feature (default & static method)
----------------------------------------------
	both above method can use to extends the interface function without effecting of implement class.

1-method definition allowed with default keyword
-----------------------------------------------	 
		 its same as instance method of class we use default keyword as modifier of method.
			 Example:

				  default String helloDefaultInInterface() {
					 return "default";	
					}

2-method definition allowed with static keyword
-----------------------------------------	
		 Example:

		  static String helloStaticMethodInInterface() {
			return "staticMethodInInterface";
		}


		Note: before to java-8 we  used only public,abstract,strictfp keywords.
		now after java-8 two keywords added to used --default, static
		if you used any others keyword you will get following error.
		"Illegal modifier for the interface method helloStaticMethodInInterface; only public, 	abstract, default, static and strictfp are permitted"
	
strictfp
------------	
		strictfp keywords can use as method modifier or class or interface. only abstract 	method cant use this.
		it used to calculate same floating point result irrespective to platform processors.(16bit/32bit/64bit )
		strictfp ---> strict to floating point as result irrespective to machine processors(16bit/32bit/64bit )
	
	
	
	
	
	
Functional Interface
----------------------
	The interface which have only one(not zero or more than 1) abstract method is called functional interface.
	we can use class level annotation to specify interface as functional.
	
	example:
	
	@FunctionalInterface
	public interface Greeting { 
	 void greet();
	}	
	
	basically functional interface normally used in lamdaexpression(functional programming).

LamdaExpression:
----------------
	lambda expression is syntactic sugar or shortest way of implementation of functional interface.
	in place of lambda expression we can use anonymous classes.

How to write LamdaExpression
----------------------------
	before learning Lamda we have to learn method reference operator (::) double colon.
	
	There are four way to use method reference(::)
	1) static method using class        ....Math::max       	---equivalent to Math.max(x,y)
	2) instance method using object     ....System.out::println ---equivalent to System.out.println(x)
	3) instance method using class      ....String.length       ----equivalent to str.length()
	4) constructor using new            .... ArrayList::new     ----equivalent to new ArrayList()
	
	Note:  argument or object value like x,y,str will be provided by Lamda-expression api automatically.


General Syntax:
--------------
	FunctionalInterface ref = (arugement)-> {body}
	(argument)-> {body}  is called lamda expression--its way to provide implementation of FunctionalInterface.
	 if method having one only argument then it cal also write in following form
	 argument -> {body}
	Method reference statement also known as one type of lamda expression.
	FunctionalInterface ref = Method reference statement
	

Example:
--------
	1)using method body
	Greeting greet1 = ()->System.out.println("LambdaExpression");
	
	2) using method reference statement here findMyAge is static method of Greeting Interface
	Greeting greet2 = Greeting::findMyAge
	
	
Stream Api 
--------------
	Now java collection can used as stream of object using stream api to improve performance.
	Need to learn
	1) foreach method
	2) Stream object
	3) built-in functional interface. (Function,Predicate)
	4)Convert Regex to Predicate


	//using collections
			List<String> names = Arrays.asList("amir","meer","java","c++");
			names.forEach(System.out::println);
			Consumer<String> cons = name-> System.out.println(name.toUpperCase());
			names.forEach(cons);

		//ways to create streams...
		
		//1) using stream() method of collection. stream is default method of Collection Interface
		Stream<String> nameStreams = names.stream();
		nameStreams.forEach(cons);
		
		
		///2) using Stream.of methods
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(System.out::println);
        
        //Predicate Interface 
        //its used to send test/validate someinput...
        
        Predicate<String> pre = name -> {return name.contains("A");};
        System.out.println(pre.test("Amir"));
        System.out.println(pre.test("amir"));
        
        
      //convert RegEx to Predicate
        Predicate<String> emailFilter = Pattern.compile("^(.+)@example.com$").asPredicate();
        	System.out.println("regex-"+ emailFilter.test("a@example.com"));
        
        
        //Function Interface
         //it use to process some input and return some output based on apply logic. 
        Function<String,String> worker  = (input) -> {return input.toLowerCase();};
		System.out.println(worker.apply("Amir Rizvi"));

		//Optional class....
		//its solution for NullPointerException
		
		String name = "Amir";
		String name2 = null;
		if (Optional.ofNullable(name).isPresent()) {
			System.out.println("Present-"+name);
		}

		if (Optional.ofNullable(name2).isPresent()) {
			System.out.println("Not-Present-"+name2);
		} 


 Stream class having following imp methods
---------------------------------------------

	processing by filter() method  -- used to filter the existing objects
	processing by map() method     -- used to modify the exisitng  object/adding new object based on existing
	processing by collect() method -- used to collect all stream object into a collection(using Collectors.toList() util class)
	Processing by count()method     -- count
	Processing by sorted()method    ---sorting natural or using comparator
	Processing by min() and max() methods  -- max or min using natural or comparator
	forEach() method      --iterating
	toArray() method      -- converting into array.


Joda Date api
------------
	// There 4  classes for date conversion (String to Date object)
		//1) LocalDate.parse() 2) LocalDateTime.parse() 3)DateTimeFormatter.ofPattern(),LocalTime
		
		//default date format for joda api is known as -ISO8601 date pattern
		//default date format for joda api is - "2019-08-07";
		//default DateTime format for joda api is "2016-04-04T11:50"
		
		String dateOnly = "2019-08-06";
		LocalDate date = LocalDate.parse(dateOnly);
		System.out.println(date.isBefore(LocalDate.now()));
		
		System.out.println(LocalDate.now()); //2019-08-07
		System.out.println(LocalTime.now());  //21:37:11.611
		System.out.println(LocalDateTime.now()); //2019-08-07T21:37:11.612
		

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyddMM");
		LocalDate parseDate = LocalDate.parse("20191011", formatter);
		System.out.println(parseDate); //2019-11-10		
		
		
		
		
		
