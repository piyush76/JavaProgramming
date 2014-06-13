/*
 * Factory
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.design.factory.currency;

/**
 * @author piyush
 */
public class Factory {

    public static void main(String args[]) {
        String country = null;
        CurrencyFactory factory = new CurrencyFactory();
        Currency symbol = factory.getCurrency(country);
        System.out.println(symbol.getSymbol());
    }

}


