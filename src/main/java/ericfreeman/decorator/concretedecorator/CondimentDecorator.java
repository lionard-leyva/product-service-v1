package ericfreeman.decorator.concretedecorator;

import ericfreeman.decorator.Beverage;

import java.math.BigDecimal;

public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;

    public abstract String getDescription();

    public BigDecimal adjustCostForSize(double baseCost) {
        BigDecimal cost = BigDecimal.valueOf(baseCost);
        Size size = beverage.getSize();
        if (size == Size.TALL) {
            cost = cost.add(new BigDecimal("0.20"));
        } else if (size == Size.GRANDE) {
            cost = cost.add(new BigDecimal("0.33"));
        } else if (size == Size.VENTI) {
            cost = cost.add(new BigDecimal("0.50"));
        } else if (size == Size.SHORT) {
            cost = cost.add(new BigDecimal("0.10"));
        }
        return cost;
    }
}
