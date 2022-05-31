package com.amir.api.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringSpitAndReverse {

    public static void main(String[] args) {

        String input = "my.name.is.zaman";
        String out = reverseWords(input);

    }

    private static String reverseWords(String input) {
    String ret = null;
        String[] words = input.split("\\.");
        List<String> list = Arrays.asList(words);
        Collections.reverse(list);
        ret = list.stream().collect(Collectors.joining("."));
        System.out.println(ret);
        return ret;

    }
}
