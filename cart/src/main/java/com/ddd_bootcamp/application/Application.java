package com.ddd_bootcamp.application;

import com.ddd_bootcamp.domain.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Product headphone = new Product("Sony Wireless headphone",
                new Price(BigDecimal.valueOf(10), Currency.getInstance("USD")));
        Item headphoneItem = new Item(headphone, 1);
        cart.add(headphoneItem);

        Product applePencil = new Product("Apple Pencil",
                new Price(BigDecimal.valueOf(100), Currency.getInstance("USD")));
        Item applePencilItem = new Item(applePencil, 2);
        cart.add(applePencilItem);


        System.out.println("Cart = " + cart);

        cart.checkOut();
        List<Product> flattenedProducts = cart.getFlattenedProducts();

       Order order = OrderApplication.createOrder();

        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");
    }


}
