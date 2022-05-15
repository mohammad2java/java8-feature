package com.amir.wrapper;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * Integer constant pool depends on literals assignment (autoboxing,valueOf(int) method)
 * if you see this method you will find that there is cache machenism for few numbers
 * IntegerCache class does cached Integer object from [-128 to 127] using static block,and high-value[127] can be configurable
 * means you can configure any high value instead of 127 using -Djava.lang.Integer.IntegerCache.high=<size>
 * java.lang.Integer.IntegerCache.high default value is null;
 * for Character cached working for range of (0,127)
 * 
 * there 8 Wrapper classes(4 number+2decimal+1boolean+1char) --Except decimal(float & double) ..caching are working for all 6 wrapper type.
 * and only for Integer we can change max value:
 * 
 */
public class WrapperDemoTest {


	@Test
	public void testNumber127Cp() {
		
		Byte i0=Byte.valueOf((byte) 127);
		Byte i01=127;
		assertTrue(i0==i01);
		
		Short i02=Short.valueOf((short) 127);
		Short i03=127;
		assertTrue(i02==i03);

		
		Integer i1=Integer.valueOf(127);
		Integer i2=127;
		assertTrue(i1==i2);
		
		
		Long i3=Long.valueOf(127L);
		Long i4=127L;
		assertTrue(i4==i3);
		
		Double d1=10.4;
		Double d2=Double.valueOf(10.4);
		
		assertFalse(d1==d2);
		
		Float f1=Float.valueOf(10.4f);
		Float f2=10.4f;
		
		assertFalse(f1==f2);
		
		Character c1 = Character.valueOf('z');
		Character c2 ='z';
		System.out.println((int)c2);
		assertTrue(c1==c2);
		
		Boolean b1 = Boolean.valueOf(false);
		Boolean b2 = false;
		assertTrue(b1==b2);
	}
	@Test
	public void testNumber128Cp() {
		Long i1=128l;
		Long i2=Long.valueOf(128);
		assertFalse(i1==i2);
	}
	
		
}
