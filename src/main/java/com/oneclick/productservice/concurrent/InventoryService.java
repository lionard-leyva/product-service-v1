package com.oneclick.productservice.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {

    private final ConcurrentHashMap<String, Product> inventory = new ConcurrentHashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
    }

    public synchronized boolean purchaseProduct(String productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            return product.reduceStock(quantity);
        }
        return false;
    }

    public ConcurrentHashMap<String, Product> getInventorySnapshot() {
        return new ConcurrentHashMap<>(inventory);
    }
}