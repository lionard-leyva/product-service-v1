package ericfreeman.decorator.concretedecorator;

import ericfreeman.decorator.Beverage;

import java.math.BigDecimal;

public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        BigDecimal cost = adjustCostForSize(beverage.cost() + 0.10);
        return cost.doubleValue();
    }
}