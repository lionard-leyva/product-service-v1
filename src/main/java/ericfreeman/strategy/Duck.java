package ericfreeman.strategy;


import ericfreeman.strategy.behavior.FlyBehavior;
import ericfreeman.strategy.behavior.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
    public void swim(){
        System.out.println("All ducks float, even decoys");
    }
    //Metodo setter para cambiar el comportamiento de la duck
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    //Metodo setter para cambiar el comportamiento de la duck
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public abstract void display();
}
