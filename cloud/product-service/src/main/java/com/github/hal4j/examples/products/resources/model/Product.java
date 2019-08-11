package com.github.hal4j.examples.products.resources.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    public static final String REL_DELETE = "delete";
    public static final String REL_UPDATE = "update";

    public final UUID id;

    public final String name;

    public final BigDecimal price;

    public Product(UUID id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product assign(UUID uuid) {
        return new Product(uuid, name, price);
    }

}
