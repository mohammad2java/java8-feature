package com.amir.internal.working.map;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Java8HashmapWorking {

    /**
     * constants from api
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final int MIN_TREEIFY_CAPACITY = 64;
     */
    public static void main(String[] args) {

        HashMap<Dept, String> map = new HashMap<>(64);

        IntStream.range(0,10).forEach(s-> {
            map.put(new Dept("amir"+s),"mumbai"+s);
            System.out.println(map);
        });

    }

}
