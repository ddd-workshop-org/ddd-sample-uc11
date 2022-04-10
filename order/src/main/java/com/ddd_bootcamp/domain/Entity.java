package com.ddd_bootcamp.domain;

public interface Entity<T> {
    public boolean hasSameIdentityAs(T other);
}
