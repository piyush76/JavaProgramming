/*
 * ArrayStackOfStrings
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.datastructure.array;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @author piyush
 */
public class ArrayStackOfStrings implements Iterable<String> {
    private String[] a;  // holds the items
    private int N;       // number of items in stack

    public ArrayStackOfStrings(int max) {
        a = new String[max];
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public Iterator<String> iterator() {
        return new ArrayIterator();
    }

    public class ArrayIterator implements Iterator<String> {
        private int i = N - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public String next() {
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        ArrayStackOfStrings stack = new ArrayStackOfStrings(max);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String item = sc.nextLine();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (stack.isEmpty()) {
                System.out.println("BAD INPUT");
            } else {
                System.out.print(stack.pop() + " ");
            }
        }
        System.out.println();
        // print what's left on the stack
        System.out.print("Left on stack: ");
        for (String s : stack) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}