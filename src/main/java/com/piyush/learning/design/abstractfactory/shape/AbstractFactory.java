package com.piyush.learning.design.abstractfactory.shape;

/**
 * Created by piyush on 7/11/14.
 */
public abstract class AbstractFactory {

    abstract Color getColor(String color);

    abstract Shape getShape(String shape) ;
}
