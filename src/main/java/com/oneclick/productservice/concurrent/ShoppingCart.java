package com.oneclick.productservice.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCart {

    private final ConcurrentHashMap<String, Integer> items = new ConcurrentHashMap<>();

    public synchronized void addItem(String itemId, int quantity) {
       items.merge(itemId, quantity, Integer::sum);
    }

    public synchronized void removeProduct(String productId) {
        items.remove(productId);
    }

   public synchronized ConcurrentHashMap<String, Integer> getItems() {
            return  new ConcurrentHashMap<>(items);
   }
}
