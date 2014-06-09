/*
 * TestNew
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.basicjava;

/**
 * @author piyush
 */
public class TestNew {

    public static void main(String[] args) {
        TestNew n = null;
        TestNew m = null;

        n = new TestNew();
        m = new TestNew();
        System.out.println(n);
        System.out.println(m);
        n.testMethod();
        m = n;
        System.out.println(n);
        System.out.println(m);
    }

    public void testMethod() {
        TestNew global = new TestNew();

        System.out.println("test method " + global);
    }

}


