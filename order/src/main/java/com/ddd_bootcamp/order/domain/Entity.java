package com.ddd_bootcamp.order.domain;

public interface Entity<T> {
    public boolean hasSameIdentityAs(T other);
}
