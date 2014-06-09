/*
 * TestConstructor
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.basicjava;

/**
 * @author piyush
 */
public class TestConstructor {
    static int i;
    static String str;
    static Long ln;
    static double dd;

    public static double getDd() {
        return dd;
    }

    public void setDd(double dd) {
        this.dd = dd;
    }

    public TestConstructor(int in, String s, Long ll) {
        this.i = in;
        this.str = s;
        this.ln = ll;
        System.out.println(i);
        System.out.println(str);
        System.out.println(ln);
    }

    public TestConstructor(TestConstructor ctr) {
        if (null == ctr) {
            throw new IllegalArgumentException("cannot be null");
        }

        this.dd = ctr.getDd();

    }

    public static void main(String[] args) {
        System.out.println(i);
        System.out.println(str);
        System.out.println(ln);
        TestConstructor cont1 = new TestConstructor(122, "sdfsdfsdasas", 9L);

    }
}
