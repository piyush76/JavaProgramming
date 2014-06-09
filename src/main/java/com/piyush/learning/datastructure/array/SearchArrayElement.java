/*
 * SearchArrayElement
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.datastructure.array;

/**
 * @author piyush
 */
public class SearchArrayElement {

    private long[] a; // ref to array a
    private int nElems; // number of data items

    public SearchArrayElement(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] > value) break;
        }
        for (int k = nElems; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println(" ");
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn; // found it
            } else if (lowerBound > upperBound) {
                return nElems; // can’t find it
            } else // divide range
            {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1; // it’s in upper half
                } else {
                    upperBound = curIn - 1; // it’s in lower half
                }
            } // end else divide range
        } // end while
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) // can’t find it
        {
            return false;
        } else // found it
        {
            for (int k = j; k < nElems; k++) // move bigger ones down
            {
                a[k] = a[k + 1];
            }
            nElems--; // decrement size
            return true;
        }
    }

    public int size() {
        return nElems;
    }

    public static void main(String[] args) {
        int maxSize = 100;
        SearchArrayElement search = new SearchArrayElement(maxSize);
        search.insert(77);
        search.insert(99);
        search.insert(44);
        search.insert(55);
        search.insert(22);
        search.insert(88);
        search.insert(11);
        search.insert(00);
        search.insert(66);
        search.insert(33);

        int searchKey = 55; // search for item

        if (search.find(searchKey) != search.size()) {
            System.out.println("Found  " + searchKey);
        } else {
            System.out.println("Can’t find " + searchKey);
        }
        search.display(); // display items
        search.delete(00); // delete 3 items
        search.delete(55);
        search.delete(99);
        search.display(); // display items again
    } // end main()
}
