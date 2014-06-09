/*
 * TestContinueAndBreak
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.basicjava;

import java.util.ArrayList;
import java.util.List;

/**
 * @author piyush
 */
public class TestContinueAndBreak {

    public static void main(String[] args) {

        TestContinueAndBreak tcb = new TestContinueAndBreak();
        tcb.testContinue();

    }

    private void testContinue() {
        //To change body of created methods use File | Settings | File Templates.
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
            if (i < 7) {
                continue;
            }
            System.out.println("added " + i);

        }
        System.out.println("list size " + list.size());
    }

}
