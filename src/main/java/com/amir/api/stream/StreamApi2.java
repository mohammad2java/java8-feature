package com.amir.api.stream;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class StreamApi2 {

    private String name;

    public static void main(String[] args) {
       //solution for anagram wala
        List<String> list = Arrays.asList("anir", "nira", "Amir","irnA");
        HashMap<String, String> ret = new HashMap<>();
        for (String s : list) {
            String sortedNameKey = s.chars().sorted().boxed().map(s2 -> String.valueOf((char) s2.intValue())).collect(Collectors.joining());
            ret.putIfAbsent(sortedNameKey,s);
        }
        System.out.println(ret.values());
    }
}
