package com.ddd_bootcamp.application;

import com.ddd_bootcamp.order.domain.Order;
import com.ddd_bootcamp.order.domain.Price;
import com.ddd_bootcamp.order.domain.Product;
import com.ddd_bootcamp.dtos.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

public class OrderApplication {
    public static void main(String[] args) {
        System.out.println("Hello from order");
    }

    public static Order createOrder(List<ProductDTO> flattenedProducts) {
        List<Product> products = flattenedProducts.stream()
                .map(productDTO -> new Product(productDTO.name,
                        new Price(productDTO.price.value, productDTO.price.currency), 10))
                .collect(Collectors.toList());

        return new Order(products);
    }

    public static Price getOrderPrice() {
        return null;
    }

}