package ericfreeman.decorator.concretedecorator;

import ericfreeman.decorator.Beverage;

import java.math.BigDecimal;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return  beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        BigDecimal cost = adjustCostForSize(beverage.cost() +0.20);
        return cost.doubleValue();
    }
}
