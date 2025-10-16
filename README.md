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
	

Notes : how many objects will be created from lamda expression/method reference.
 
		 Rules : 
		 1) if lamda expression does not use any variable local/instance jvm will create singleton object regardless 
		 how many times lamda expression executed.
		 like :  Predicate<String> pr = s->s.isEmpty();

		 1) if lamda expression use any variable local/instance jvm will create many objects equal to how many times lamda expression executed.
		 like :  
		 String name="amir"
		 Predicate<String> pr = s->s.isEmpty() && name.isEmpty();
		 here name is outer variables.

		 but if we will make it final locally or static variable ,,it will create single object for predicate.
		 like 
		  final String name="amir" 
		 Predicate<String> pr = s->s.isEmpty() && name.isEmpty();


		 for method ref:
		 --------------------
		 static method refrence will create single predicate Object
		 example:
		 Predicate<String> pr = =TestClass::checkEmpty;

		 instance method refrence will create many predicate Object as number of its called.
		 example:
		 Predicate<String> pr = =new TestClass()::checkEmpty;
 
 
	
	
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
	
	example of nested group by.
	Map<String, Map<String, Integer>> group = employees.stream().
                collect(Collectors.groupingBy(Employee::getDept, Collectors.groupingBy(Employee::getCity, Collectors.summingInt(Employee::getSal))));
                                
	  ==Parallel Streaming:
	  -----------------------
		  /*
			 * parallel streaming can be achieved via two way.
			 * 1) using parallel() of Stream
			 * 2) using parallelStream() of Collection Interface(its default method)
			 * internally it use forkjoin threadpool to manage all to run parallely using thread.
			 */
	


		Parallel Streams are cool, so should you use it always?
		A big No!!
		It is easy to convert sequential Stream to parallel Stream just by adding .parallel, 
		does not mean you should always use it.
		There are lots of factors you need to consider while using parallel streams otherwise 
		you will suffer from negative impacts of parallel Streams.
		Parallel Stream has much higher overhead than sequential Stream and 
		it takes a good amount of time to coordinate between threads.
		You need to consider parallel Stream if and only if:
		
		1) You have a large dataset to process.
		2) if your source stream should be splittable.
     	For example:
	    ArrayList is very easy to split, as we can find a middle element by its index and split it
	    but LinkedList is very hard to split and does not perform very well in most of the cases.
		3)You are actually suffering from performance issues.
		
		The simplest formula for measuring parallelism is “NQ” model as provided by Brian Goetz in his presentation.
	   ==
		NQ Model:
		N x Q >10000
		where,
     	  N = number of items in the dataset
	      Q = amount of work per item
	 if you see here N or Q should be big to start parallel streaming(multithreading).
		

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


##java Data Type deep concept
   ----------------------------------------------
   
	      java contain 8 data type(primitives)
	      6 type for number - 6(byte-1Byte,short-2Byte,int-4Byte,long-8Byte,float-4Byte,double-8Byte)
	      1 type for boolean (boolean-1bit) [0,1]
	      1 type for character(char-2byte) --only positive num[0-(2^16-1)] = [0 to 65535]
	      for byte -contains both negative & positive -- so in 1 byte = 8 bits
	      total possible number using 8 bit = 2^8 = 256 means half number should be negative 
	      and half number should be positive
	      first negative number; 256/2 = -128
	      last postive number = 256 -(128+1) = 127
	      so validate range [-128,127]
	      formula = total possible = (last-first+1)  = 256 = 127-(-128)+1=256
	      1 added because zero belongs to positive number
	      note: always java store negative num inform of 2's complement.
	      
              //2s complement rules => reverse all bit from left to right plus
              change all zero to 1 from left to right till 1st one
              example:
              num =-5 =  binary for 5 = 00000101
              apply 2s complement rules = 11111011 (java store for -5)
      
      
      
           */
          public static void main(String[] args) {
              byte num = -5;  // binary 1 = 00000001 =>1s complement = 11111110 =2's compl =11111110
              String s = Integer.toBinaryString(num);
              System.out.println(s.substring(24));
              
          }
      
      
      
      
      
      
      
      major minor version for java.
      ================================
      sometimes if project/sourcecode is compiled with higher version and run in lower version so you get error:
      "java.lang.UnsupportedClassVersionError: UnsupportedVersionErrorExample : Unsupported major.minor version 52.0"
      formula:
	major version number = 44+java_version 
	like for java 8
	major version number = 44+8=52
	if see below table for java 8 you will find 52.
	---------------------------------------------
	Java SE 19 = 63 (0x3F hex),
	Java SE 18 = 62 (0x3E hex),
	Java SE 17 = 61 (0x3D hex),
	Java SE 16 = 60 (0x3C hex),
	Java SE 15 = 59 (0x3B hex),
	Java SE 14 = 58 (0x3A hex),
	Java SE 13 = 57 (0x39 hex),
	Java SE 12 = 56 (0x38 hex),
	Java SE 11 = 55 (0x37 hex),
	Java SE 10 = 54 (0x36 hex),[4]
	Java SE 9 = 53 (0x35 hex),[5]
	Java SE 8 = 52 (0x34 hex),
	Java SE 7 = 51 (0x33 hex),
	Java SE 6.0 = 50 (0x32 hex),
	Java SE 5.0 = 49 (0x31 hex),
	JDK 1.4 = 48 (0x30 hex),
	JDK 1.3 = 47 (0x2F hex),
	JDK 1.2 = 46 (0x2E hex),
	JDK 1.1 = 45 (0x2D hex).
	
	ref:
	https://en.wikipedia.org/wiki/Java_class_file#General_layout



---

## 🧩 1. Internal working of`HashMap` in java8+?

A **HashMap** stores key–value pairs.
It allows **fast access** to values using keys by computing a **hash code**.

```java
Map<String, Integer> map = new HashMap<>();
map.put("apple", 10);
map.put("banana", 20);
System.out.println(map.get("apple")); // 10
```

---

## ⚙️ 2. Internal Structure

In **Java 8**, a `HashMap` is implemented using:

* **Array of Nodes** (buckets)
* Each **Node** contains: `key`, `value`, `hash`, and `next` (for chaining)
* If too many elements fall in the same bucket, Java 8 converts that linked list into a **balanced tree (red-black tree)** for better performance.

---

### 🧱 Internal Representation

```java
class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next; // points to next node in same bucket
}
```

---

## 🧮 3. How `put()` Works

Let’s see what happens when you do `map.put("apple", 10)`:

1. **Compute hash:**
   `hash = key.hashCode()`
   (Then mix bits to reduce collisions)

2. **Find bucket index:**
   `index = (n - 1) & hash`
   where `n` = current capacity of the table (default 16).

3. **If bucket is empty:**
   Create a new Node and insert it.

4. **If bucket is not empty (collision):**

    * Compare the hash and key.
    * If same key found → **replace the value**.
    * If different keys → **link it to the next node** (forming a chain).
    * If chain length > 8 → it’s **converted to a tree** (to O(log n) lookup).

---

## 🔍 4. How `get()` Works

When you do `map.get("apple")`:

1. Compute the hash again.
2. Find the bucket index using `(n - 1) & hash`.
3. Search through:

    * If tree → binary search in tree nodes.
    * If linked list → traverse each node using `.next`.
4. If key matches → return its value.

---

## 📊 6. Performance Summary

| Operation  | Average Time | Worst Case (Tree) |
| ---------- | ------------ | ----------------- |
| `put()`    | O(1)         | O(log n)          |
| `get()`    | O(1)         | O(log n)          |
| `remove()` | O(1)         | O(log n)          |


## Treeify Happens When:

✅ Bucket chain length > 8 (TREEIFY_THRESHOLD)
AND
✅ Current HashMap capacity ≥ 64 (MIN_TREEIFY_CAPACITY)

➡️ Then the linked list is treeified (converted into red-black tree nodes).

## Untreeify — Convert Tree → Linked List

When the map shrinks (for example, after removing elements):

If a tree node’s bucket size drops below 6 (UNTREEIFY_THRESHOLD),
the bucket will be converted back to a linked list for memory efficiency.
---



