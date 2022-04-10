package com.ddd_bootcamp.dtos;

import java.math.BigDecimal;
import java.util.Currency;

public class PriceDTO {
    public BigDecimal value;
    public Currency currency;

    public PriceDTO(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }
}
