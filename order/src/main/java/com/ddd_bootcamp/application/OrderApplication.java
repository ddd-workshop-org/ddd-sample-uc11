package com.ddd_bootcamp.application;

import com.ddd_bootcamp.order.domain.Order;
import com.ddd_bootcamp.order.domain.OrderId;
import com.ddd_bootcamp.order.domain.Price;
import com.ddd_bootcamp.order.domain.Product;
import com.ddd_bootcamp.dtos.ProductDTO;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderApplication {
    public static void main(String[] args) {
        System.out.println("Hello from order");
    }

    public static Order createOrder(List<ProductDTO> flattenedProducts) {
        OrderId orderId = new OrderId("123-134-567-980-145");

        //Get weight of Product by name from some service.
        Map<String, Double> productWeights = new HashMap<>();
        productWeights.put("Sony Wireless headphone", 10D);
        productWeights.put("Apple Pencil", 10D);

        List<Product> products = flattenedProducts.stream()
                .map(productDTO ->
                        new Product(productDTO.name,
                                new Price(productDTO.price.value, productDTO.price.currency),
                                productWeights.get(productDTO.name)))
                .collect(Collectors.toList());

        return new Order(products, orderId);
    }

    public static Price getOrderPrice(Order order) {
        return order.totalPrice();
    }

}