package ericfreeman.decorator;

import ericfreeman.decorator.concretedecorator.Milk;
import ericfreeman.decorator.concretedecorator.Mocha;
import ericfreeman.decorator.concretedecorator.Soy;
import ericfreeman.decorator.concretedecorator.Whip;

public class StarBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDescription()+" $" + beverage2.cost());

        Beverage beverage3 = new Espresso();
        beverage3.setSize(Beverage.Size.VENTI);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Milk(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

        Beverage beverage4 = new Decaf();
        beverage4 = new Mocha(beverage4);
        beverage4 = new Whip(beverage4);
        System.out.println(beverage4.getDescription() + " $" + beverage4.cost());

        Beverage beverage5 = new DarkRoast();
        beverage5 = new Mocha(beverage5);
        beverage5 = new Soy(beverage5);
        beverage5 = new Whip(beverage5);
        System.out.println(beverage5.getDescription() + " $" + beverage5.cost());
    }
}