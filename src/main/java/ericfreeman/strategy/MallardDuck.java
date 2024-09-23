package ericfreeman.strategy;

import ericfreeman.strategy.implmentconcrets.FlyWithWings;
import ericfreeman.strategy.implmentconcrets.Quack;


public class MallardDuck extends Duck {
    //hereda todos los metodos y propiedades definidos en la clase Duck
    public MallardDuck() {
        quackBehavior = new Quack(); //asigna el comportamiento Quack
        flyBehavior = new FlyWithWings(); //Asigna el comportamiento FlyWithWings
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard Duck");
    }
}

