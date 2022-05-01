package com.ddd_bootcamp.application;

import com.ddd_bootcamp.domain.*;
import com.ddd_bootcamp.dtos.PriceDTO;
import com.ddd_bootcamp.dtos.ProductDTO;
import com.ddd_bootcamp.order.domain.Order;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

public class CartApplication {
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

        List<ProductDTO> productDTOList = flattenedProducts.stream()
                .map(product -> new ProductDTO(product.getName(),
                        new PriceDTO(product.getPrice().getValue(), product.getPrice().getCurrency())))
                .collect(Collectors.toList());

        Order order = OrderApplication.createOrder(productDTOList);

        System.out.println("-------------------------------------------------------------------");
        System.out.println("order = " + order);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("order price :" + OrderApplication.getOrderPrice(order));
        System.out.println("-------------------------------------------------------------------");

    }


}
