package com.ddd_bootcamp.order.domain.events;

import com.ddd_bootcamp.order.domain.Price;

public class CartItem {
    private String name;
    private int quantity;
    private Price price;

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public CartItem(String name, Price price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
