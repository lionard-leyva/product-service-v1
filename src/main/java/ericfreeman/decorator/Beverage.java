package ericfreeman.decorator;

public abstract class Beverage {
    public enum Size {
       TALL, GRANDE, VENTI, SHORT, LONG, PINT, TINY
    }

    Size size = Size.TALL;

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }
    public abstract double cost();

    public void setSize(Size size) {
        this.size = size;
    }
    public Size getSize() {
        return this.size;
    }
}
