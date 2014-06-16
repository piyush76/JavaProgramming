package com.piyush.learning.basicjava;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by piyush on 6/16/14.
 */
public class EnumBasicExampleTest{

    private static final double DELTA = 1e-15;


    @Test
    public void testCalculateCostForMocha(){
        EnumBasicExample testEnum = new EnumBasicExample(EnumBasicExample.Coffee.Mocha);
        //testEnum.calculateCost();
        Assert.assertEquals("Wrong price for Mocha", 1.29, testEnum.calculateCost(),DELTA );

    }

    @Test
    public void testCalculateCostLatte(){
        EnumBasicExample testEnum = new EnumBasicExample(EnumBasicExample.Coffee.Latte);
        Assert.assertEquals("Wrong price for Latte", 2.17, testEnum.calculateCost(),DELTA );

    }

    @Test
    public void testCalculateForCappuccino(){
        EnumBasicExample testEnum = new EnumBasicExample(EnumBasicExample.Coffee.Cappuccino);
        Assert.assertEquals("Wrong price for Cappuccino", 3.29, testEnum.calculateCost(),DELTA );

    }

    @Test
    public void testCalculateForDarkRoast(){
        EnumBasicExample testEnum = new EnumBasicExample(EnumBasicExample.Coffee.DarkRoast);
        Assert.assertEquals("Wrong price for DarkRoast", 3.19, testEnum.calculateCost(),DELTA );

    }




}
