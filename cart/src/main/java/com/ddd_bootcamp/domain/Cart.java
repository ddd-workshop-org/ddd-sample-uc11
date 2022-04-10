package com.ddd_bootcamp.domain;

import com.ddd_bootcamp.domain.events.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cart implements Entity<Cart> {

    private CartId cartId;
    private List<DomainEvent> events = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private boolean isCheckedOut;

    public Cart() {
        cartId = CartId.generateCartId();
    }

    public void add(Item item) {
        ItemAddedToCartEvent itemAddedEvent =
                new ItemAddedToCartEvent(item.getProductName(),
                        item.getQuantity(), item.getProductPrice());

        apply(itemAddedEvent);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return items.toString();
    }

    public void remove(Item item) {
        ItemRemovedFromCartEvent itemRemovedFromCartEvent =
                new ItemRemovedFromCartEvent(item.getProductName());

        apply(itemRemovedFromCartEvent);
    }

    public void checkOut() {
        List<CartItem> cartItems = items.stream().map(item ->
                new CartItem(item.getProductName(),
                        item.getProductPrice(),
                        item.getQuantity())).collect(Collectors.toList());

        apply(new CartCheckedOutEvent(cartItems));
    }

    private void apply(ItemAddedToCartEvent event) {
        events.add(event);
        this.items.add(new Item(new Product(event.getProductName(), event.getPrice()), event.getQuantity()));
    }

    private void apply(ItemRemovedFromCartEvent event) {
        events.add(event);
        this.items.
                remove(this.items.stream().filter(item -> item.getProductName().equals(event.getProductName())).findFirst().get());
    }

    private void apply(CartCheckedOutEvent event) {
        events.add(event);
        this.isCheckedOut = true;
    }

    public Set<String> removedProductNames() {
        return events.stream()
                .filter(event -> event instanceof ItemRemovedFromCartEvent)
                .map(event -> ((ItemRemovedFromCartEvent) event).getProductName())
                .collect(Collectors.toSet());
    }

    public List<Product> getFlattenedProducts() {
        return items.stream().flatMap(item ->
                item.getFlattenedProducts().stream()).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;
        return cartId.equals(cart.cartId);
    }

    @Override
    public int hashCode() {
        return cartId.hashCode();
    }

    @Override
    public boolean hasSameIdentityAs(Cart other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return cartId.equals(other.cartId);
    }
}