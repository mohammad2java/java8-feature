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
		"Illegal modifier for the interface method helloStaticMethodInInterface; 
		only public, abstract, default, static and strictfp are permitted"
	
strictfp
------------	
	strictfp keywords can use as method modifier or class or interface. only abstract method cant use this.
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

	MostIMP Inbuilt Functional Interface
	1) R java.util.function.Function.apply(T t)     -- example -streamObj.map()
	2) boolean java.util.function.Predicate.test(T t)  -- streamObj.filter()
	3) void java.util.function.Consumer.accept(T t)  --streamObject.foreach()
	4) R java.util.function.Supplier.get()   --Stream.generate()
	

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
CORE INTERFACE FOR STREAM API
--------------------------------
						BaseStream
						    |
	 [IntStream,DoubleStream,LongStream,Stream<T>]

	also built-in functional interface. (Function,Predicate,Supplier,Consumer)

	 1) stream() method to generate Stream from Other                                   
	                                  1) Collection(I).stream()
	                                  2) Arrays(C).stream(arr)
	                                  
	  2)to generate Stream by core Interface static method:
	  --------------------------------------------------------
	  Reference one
	 -----------------
	 Stream.empty();
	 Stream.generate(Math::random);
	 Stream.of(10);
	 Stream.of(1,2,3,4,4);
	 Stream.iterate(10, n->n+2);
	 
	 primitive-one(IntStream,LongStream,DoubleStream[doesnt have range()/rangeClosed() ])
	 ------------------------------------------------------------------------------------
	 IntStream.empty();
	 IntStream.generate(Math::random);
	 IntStream.of(10);
	 IntStream.of(1,2,3,4,4);
	 IntStream.iterate(10, n->n+2);
	 +2 extra 
	 IntStream.range
	 IntStream.rangeClosed
	 
	  
	                                  
	






	Now java collection can used as stream of object using stream api to improve performance.
	Need to learn
	0) basic concept of stream
	1) foreach method
	2) Stream object
	3) built-in functional interface. (Function,Predicate,Supplier,Consumer)
	4)Convert Regex to Predicate


		basic concept of stream
		---------------------------
		every stream consist 3 part 1) initialization of stream 2) processing of stream 3) termination of stream
		flow of each part will be:  init->processing->terminate
		 basic-rule
		 1) - modification in stream will not impact of its source(generator) object
		 2) - once stream terminated cant be use again.
		 3) init --  create Stream object from any source object 
		 4) processing --  applying some non terminated method onto the stream like .filter,map,
		 5) terminate -- applying some terminated method to terminate the stream & get expected result ,like foreach,collect


	//using collections
			List<String> names = Arrays.asList("amir","meer","java","c++");
			names.forEach(System.out::println);
			Consumer<String> cons = name-> System.out.println(name.toUpperCase());
			names.forEach(cons);

		//ways to create streams...(comes under the initialization)
		-----------------------------------------------------------------
		
		1) Collection to Stream - using collection.stream() - This is default method of Collection Interface
		Stream<String> nameStreams = names.stream();
		nameStreams.forEach(cons);
		
		
		2) literal to Stream --using Stream.of methods
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(System.out::println);
        
      
      3)Array to Stream  
      
      Arrays.stream(arr);
        
        
      4) String to Stream<Character>
      ----------------------------------
      Stream<Character> stream = "Amir".chars().boxed().map(s->Character.valueOf((char)s.intValue()));
        
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
		
		
		
		
		
# core concept behind date data-type in java
 ---------------------------------------------------

	 * before time api(package) there there was 2 classes to deal with date.
	1) java.util.Date (1.0)    (dont confuse with java.sql.Date --> this for jdbc api)
	2) java.util.Calendar(1.1)
	
	=> why calender having many useful method with date--adding/substracting year/month/second 
	  can be get Date object from calendar using getTime and also can set using setTime.
	=> Date & Calendar is mutable object ( which is bad)
	=> Calendar.getInstance(); return object of java.util.GregorianCalendar
	=> Calendar & Date work with system-timezone, it cant work with specified timezone.even 
	 
	 if Calendar have argument to pass timezone.
	  you have only one way to work with timezone ,you have set system-timezone as target one.
	  TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Asia/Manila")));
	  time-package api happlily working with specified TimeZone.
	
	 Time API
	 -------------
	 LocalDate  -> deals with date only
	 LocalTime  -> deals with time only 
	 LocalDateTime -> Date+Time 
	 ZonedDateTime  -> date+time+zone --> best alernative for java.util.Date & Calendar
	 Instant  --> available as bridge between date/calendar <-> ZonedDateTime  --> always used UTC timezone
	
	=> you can get Date object from TimeAPI using toInstant and vice versa.
	=> Instant is availabe in Date,Calendar & Time API also.
	=> Alternative for simpledataformat is DateTimeFormatter .
	*
	*/
	
	
	example:
	
	// Date <-> ZonedDateTime
		Date date = new Date();
		System.out.println(date);
		
		Instant instant = date.toInstant();
		ZonedDateTime from = ZonedDateTime.ofInstant(instant, ZoneId.of("Asia/Calcutta"));
		System.out.println(from);
		
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(now);
		
		Instant instant2 = now.toInstant();
		Date from2 = Date.from(instant2);
		System.out.println(from2);
		
		// output
		
			Wed Apr 27 16:53:23 IST 2022
			2022-04-27T16:53:23.811+05:30[Asia/Calcutta]
			2022-04-27T16:53:23.903014+05:30[Asia/Calcutta]
			Wed Apr 27 16:53:23 IST 2022

		
		
		
