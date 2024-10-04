package ericfreeman.decorator.concretedecorator;

import ericfreeman.decorator.Beverage;

import java.math.BigDecimal;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return  beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        BigDecimal cost = adjustCostForSize(beverage.cost() +0.33);
        return cost.doubleValue();
    }
}
