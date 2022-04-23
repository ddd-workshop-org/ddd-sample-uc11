package com.ddd_bootcamp.application;

import com.ddd_bootcamp.order.domain.Order;
import com.ddd_bootcamp.order.domain.OrderId;
import com.ddd_bootcamp.order.domain.Price;
import com.ddd_bootcamp.order.domain.Product;
import com.ddd_bootcamp.order.domain.events.CartCheckedOutEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventListener {

    public void listenTo(CartCheckedOutEvent event) {
        OrderId orderId = new OrderId("123-134-567-980-145");

        //Get weight of Product by name from some service.
        Map<String, Double> productWeights = new HashMap<>();
        productWeights.put("Sony Wireless headphone", 10D);
        productWeights.put("Apple Pencil", 10D);

        List<Product> products = event.getItems().stream()
                .map(cartItem ->
                        new Product(cartItem.getName(),
                               cartItem.getPrice(),
                                productWeights.get(cartItem.getName())))
                .collect(Collectors.toList());

        Order order =  new Order(products, orderId);
    }

}
