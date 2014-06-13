package com.piyush.learning.basicjava;

/**
 * Created by piyush on 6/13/14.
 */
public class EnumBasicExample {


    public static enum Coffee {
        Mocha(1.29),
        Latte(2.17) ,
        Cappuccino(3.29),
        DarkRoast(3.19);

        private double cost;

        private Coffee(double cost){
            this.cost = cost;
        }

    }




    public static int calculateCost(String type){


        return 0 ;
    }


}
