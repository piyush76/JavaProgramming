package com.piyush.learning.datastructure.datastructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by piyush on 1/29/14.
 * Demo to explain difference between a TreeMap and HashMap.
 * HashMap doesn't maintain the order that mean the keys and values are not in
 * Sorted order but TreeMap maintains the order that is keys are sorted.
 * Use HashMap most of the times but use TreeMap
 * when you need the key to be sorted (when you need to iterate the keys).
 */


public class TestTreeMap {

    public static void main(String[] args) {

        Map map1 = generateRandomTreeMap();

        Iterator it = map1.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(pairs.getKey() + " = " + pairs.getValue());
        }

        Map map2 = generateRandomHashMap();

        Iterator iter = map2.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pairs = (Map.Entry) iter.next();
            System.out.println(pairs.getKey() + " = " + pairs.getValue());
        }

    }


    public static Map generateRandomTreeMap() {
        Map<Integer, Double> randomMap = new TreeMap<Integer, Double>();

        for (int i = 0; i < 100; i++) {
            double random = Math.random();
            System.out.println("Putting in map Key : " + i + " Value:" + random);
            randomMap.put(i, random);
        }

        return randomMap;

    }

    public static Map generateRandomHashMap() {
        Map<Integer, Double> randomMap = new HashMap<Integer, Double>();

        for (int i = 0; i < 100; i++) {
            double random = Math.random();
            System.out.println("Putting in map Key : " + i + " Value:" + random);
            randomMap.put(i, random);
        }

        return randomMap;

    }

}
