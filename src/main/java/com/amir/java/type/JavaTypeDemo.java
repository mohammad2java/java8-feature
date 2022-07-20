package com.amir.java.type;

public class JavaTypeDemo {
    /*
    java contain 8 data type(primitives)
   6 type number - 6(byte-1Byte,short-2Byte,int-4Byte,long-8Byte,float-4Byte,double-8Byte)
   1 type for boolean (boolean-1bit) [0,1]
   1 type for character(char-2byte) --only positive num[0-(2^16-1)] = [0 to 65535]
       // for byte -contains both negative & positive -- so in 1 byte = 8 bits
        // total possible number using 8 bit = 2^8 = 256 means half number should be negative and half number should be positive
        // first negative number; 256/2 = -128
        // last postive number = 256 -(128+1) = 127
        // so validate range [-128,127]
        // formula = total possible = (last-first+1)  = 256 = 127-(-128)+1=256
        //1 added because zero belongs to positive number
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
}
