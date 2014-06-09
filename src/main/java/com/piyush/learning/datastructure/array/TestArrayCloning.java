/*
 * TestArray
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.datastructure.array;

/**
 * @author piyush
 */
public class TestArrayCloning {

    public static void main(String[] args) {
        int[] a = {11, 12, 13, 14, 15};
        int[] b;
        System.out.println(a[2]);
        b = a.clone();
        b[2] = 16;
        System.out.println(a[2]);
        System.out.println(b[2]);

    }
}
