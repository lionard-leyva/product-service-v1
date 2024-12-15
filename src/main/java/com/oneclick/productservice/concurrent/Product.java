package com.oneclick.productservice.concurrent;

public class Product {
    private final String id;
    private final String name;

    private volatile int  stock;

    public Product(String id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public synchronized boolean reduceStock(int quantity) {
        if( stock >= quantity ) {
            stock -= quantity;
            return true;
        }
        return false;
    }
}
