package com.piyush.learning.datastructure.datastructure;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by piyush on 1/29/14.
 */
public class TestHashMapIterator {

    static HashMap<String, Integer> testMap = new HashMap<String, Integer>();

    static {
        for (int i = 0; i < 1000000; i++) {
            testMap.put("key_" + i, i);
        }
    }

    public static void main(String[] args) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        //First way using entrySet in for-each loop
        for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
        System.out.println("Using entrySet() in for-each loop : " + (Calendar.getInstance().getTimeInMillis() - startTime));
        startTime = Calendar.getInstance().getTimeInMillis();
        //Second way using keySet() in for-each loop
        for (String key : testMap.keySet()) {
            testMap.get(key);
        }

        System.out.println("Using keySet() in for-each loop : " + (Calendar.getInstance().getTimeInMillis() - startTime));
        startTime = Calendar.getInstance().getTimeInMillis();
        //Third way using Iterator on entrySet() in while loop
        Iterator<Map.Entry<String, Integer>> itr1 = testMap.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry<String, Integer> entry = itr1.next();
            entry.getKey();
            entry.getValue();
        }

        System.out.println("Using entrySet() and iterator : " + (Calendar.getInstance().getTimeInMillis() - startTime));
        startTime = Calendar.getInstance().getTimeInMillis();
        //Third way using Iterator on keySet() in while loop
        Iterator<String> itr2 = testMap.keySet().iterator();
        while (itr2.hasNext()) {
            String key = itr2.next();
            testMap.get(key);
        }
        System.out.println("Using keySet() and iterator : " + (Calendar.getInstance().getTimeInMillis() - startTime));
    }
}