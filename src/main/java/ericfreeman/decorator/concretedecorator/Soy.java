package ericfreeman.decorator.concretedecorator;

import ericfreeman.decorator.Beverage;

import java.math.BigDecimal;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        BigDecimal cost = adjustCostForSize(beverage.cost() + 0.15);
        return cost.doubleValue();
    }
}