package ericfreeman.strategy;

import ericfreeman.strategy.implmentconcrets.Squeak;

public class MainStrategy {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
        mallard.display();
        mallard.setQuackBehavior(new Squeak());
        mallard.performQuack();
    }
}
