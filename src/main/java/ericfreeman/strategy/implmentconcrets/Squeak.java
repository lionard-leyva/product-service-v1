package ericfreeman.strategy.implmentconcrets;

import ericfreeman.strategy.behavior.QuackBehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak!");
    }
}
