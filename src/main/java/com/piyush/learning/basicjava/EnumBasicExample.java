package com.piyush.learning.basicjava;

/**
 * Created by piyush on 6/13/14.
 */
public class EnumBasicExample {

    private Coffee coffeeName;
    private Condiments condiment ;

    public EnumBasicExample(Coffee cName,Condiments condiments ) {

        this.condiment = condiments;
        this.coffeeName = cName;
    }

    public EnumBasicExample(Coffee cName ) {


        this.coffeeName = cName;
    }




    public static enum Coffee {
        Mocha(1.29),

        Latte(2.17) ,

        Cappuccino(3.29),

        DarkRoast(3.19);

        private double cost;

        Coffee(double cost) {
            this.cost = cost;
        }
    }


    public static enum Condiments {
        Milk(.29),

        Suger(.17) ,

        Creamer(.19),

        Cream(.27);

        private double cost;

        Condiments(double cost) {
            this.cost = cost;
        }
    }

    public double calculateCost(){
        switch(coffeeName){
            case Mocha:
                System.out.println("Your Mocha will cost " + Coffee.Mocha.cost );
                return Coffee.Mocha.cost;
            case Latte:
                System.out.println("Your Latte will cost " + Coffee.Latte.cost );
                return Coffee.Latte.cost;
            case Cappuccino:
                System.out.println("Your Latte will cost " + Coffee.Cappuccino.cost );
                return Coffee.Cappuccino.cost;
            case DarkRoast:
                System.out.println("Your Latte will cost " + Coffee.DarkRoast.cost );
                return Coffee.DarkRoast.cost;


        }

        return 0;
    }


}
