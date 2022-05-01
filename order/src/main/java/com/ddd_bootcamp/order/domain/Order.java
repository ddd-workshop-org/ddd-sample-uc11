package com.ddd_bootcamp.order.domain;

import java.math.BigDecimal;
import java.util.List;

public class Order implements Aggregate {
    private List<Product> products;
    private OrderId orderId;

    public Order(List<Product> products, OrderId orderId) {
        this.products = products;
        this.orderId = orderId;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", orderId=" + orderId +
                '}';
    }

    public Price totalPrice() {
        return products.stream()
                .map(product ->
                        product.getPrice()
                                .plus(new Price(new BigDecimal(product.getWeight() * 0.1), Price.defaultCurrency)))
                .reduce((price1, total) -> total.plus(price1)).get();
    }
}
