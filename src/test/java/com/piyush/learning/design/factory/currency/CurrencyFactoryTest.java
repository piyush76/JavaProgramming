package com.piyush.learning.design.factory.currency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by piyush on 6/13/14.
 */
public class CurrencyFactoryTest {

    @Test(expected=IllegalArgumentException.class)
    public void testCurrencyForBlank(){
        CurrencyFactory factory = new CurrencyFactory();
        factory.getCurrency(" ");
    }


    @Test(expected=IllegalArgumentException.class)
    public void testCurrencyForNull(){
        CurrencyFactory factory = new CurrencyFactory();
        factory.getCurrency(null);
    }

    @Test
    public void testCurrencyUSD(){
        CurrencyFactory factory = new CurrencyFactory();
        Assert.assertEquals("Wrong Currency for US","USD",factory.getCurrency("US").getSymbol());
    }

    @Test
    public void testCurrencySNGDoller(){
        CurrencyFactory factory = new CurrencyFactory();
        Assert.assertEquals("Wrong Currency for Singapore","SGD",factory.getCurrency("Singapore").getSymbol());
    }

    @Test
    public void testCurrencyIND(){
        CurrencyFactory factory = new CurrencyFactory();
        Assert.assertEquals("Wrong Currency for India","Rs",factory.getCurrency("India").getSymbol());
    }



}
