package com.piyush.learning.design.abstractfactory.shape;

/**
 * Created by piyush on 7/11/14.
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
