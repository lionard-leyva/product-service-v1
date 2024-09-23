package ericfreeman.strategy.implmentconcrets;

import ericfreeman.strategy.behavior.FlyBehavior;

public class flyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I' can't fly.");
    }
}
