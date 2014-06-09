/*
 * Factory
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.design.factory;

/**
 * @author piyush
 */
public class Factory {

    public static void main(String args[]) {
        String country = "US";
        Currency rupee = CurrencyFactory.createCurrency(country);
        System.out.println(rupee.getSymbol());
    }

}


