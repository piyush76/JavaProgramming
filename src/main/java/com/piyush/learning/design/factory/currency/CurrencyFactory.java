/*
 * CurrencyFactory
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.design.factory.currency;

import com.piyush.learning.design.factory.currency.Currency;
import com.piyush.learning.design.factory.currency.Rupee;
import com.piyush.learning.design.factory.currency.SGDDollar;
import com.piyush.learning.design.factory.currency.USDollar;

/**
 * @author piyush
 */
class CurrencyFactory {

    public Currency getCurrency(String country) {

        if((country == null) || (country == " ")){
           throw new IllegalArgumentException("Country Can't be null");
        }
        if (country.equalsIgnoreCase("India")) {
            return new Rupee();
        } else if (country.equalsIgnoreCase("Singapore")) {
            return new SGDDollar();
        } else if (country.equalsIgnoreCase("US")) {
            return new USDollar();
        }

        throw new IllegalArgumentException("No such Country");


    }

}




