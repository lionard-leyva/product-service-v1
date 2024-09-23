package ericfreeman.strategy.implmentconcrets;

import ericfreeman.strategy.behavior.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}
