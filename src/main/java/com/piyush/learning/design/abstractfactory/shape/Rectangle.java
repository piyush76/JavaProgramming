package com.piyush.learning.design.abstractfactory.shape;

/**
 * Created by piyush on 7/11/14.
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
