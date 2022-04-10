package com.ddd_bootcamp.order.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Price {
    private BigDecimal value;
    private Currency currency;
    public static Currency defaultCurrency = Currency.getInstance("USD");

    public Price(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public Price reduceByPercent(int discountPercentage) {
        return new Price(value.subtract(value.divide(new BigDecimal(discountPercentage))), defaultCurrency);
    }

    public Price plus(Price otherPrice) {
       return new Price(this.value.add(otherPrice.value), this.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(value, price.value) &&
                Objects.equals(currency, price.currency);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }


    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}