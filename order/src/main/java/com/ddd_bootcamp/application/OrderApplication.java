package com.ddd_bootcamp.application;

import com.ddd_bootcamp.domain.Order;
import com.ddd_bootcamp.domain.Price;
import com.ddd_bootcamp.dtos.ProductDTO;

import java.util.List;

public class OrderApplication {
    public static void main(String[] args) {
        System.out.println("Hello from order");
    }

    public static Order createOrder(List<ProductDTO> flattenedProducts) {
        return null;
    }

    public static Price getOrderPrice() {
        return null;
    }

}