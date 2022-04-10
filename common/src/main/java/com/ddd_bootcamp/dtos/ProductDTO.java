package com.ddd_bootcamp.dtos;

public class ProductDTO {
    public String name;
    public PriceDTO price;

    public ProductDTO(String name, PriceDTO price) {
        this.name = name;
        this.price = price;
    }
}
