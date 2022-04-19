package com.ddd_bootcamp.order.domain;

public class OrderId {
    private String id;

    public OrderId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderId{" +
                "id='" + id + '\'' +
                '}';
    }
}
