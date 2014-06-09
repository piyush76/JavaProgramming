/*
 * Currency
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.design.factory;

/**
 * @author piyush
 */
interface Currency {
    String getSymbol();
}

// Concrete Rupee Class code
class Rupee implements Currency {

    public String getSymbol() {
        return "Rs";
    }
}

// Concrete SGD class Code
class SGDDollar implements Currency {

    public String getSymbol() {
        return "SGD";
    }
}

// Concrete US Dollar code
class USDollar implements Currency {

    public String getSymbol() {
        return "USD";
    }
}


