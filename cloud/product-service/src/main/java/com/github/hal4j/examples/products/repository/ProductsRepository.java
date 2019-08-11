package com.github.hal4j.examples.products.repository;

import com.github.hal4j.examples.products.resources.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class ProductsRepository {

    private final ConcurrentMap<UUID, Product> items = new ConcurrentHashMap<>();

    public Optional<Product> get(UUID uuid) {
        return Optional.ofNullable(items.get(uuid));
    }

    public Collection<Product> findAll() {
        return items.values();
    }

    public Product save(Product product) {
        items.put(product.id, product);
        return product;
    }

    public boolean delete(Product product) {
        return items.remove(product.id) != null;
    }

    public boolean delete(UUID uuid) {
        return items.remove(uuid) != null;
    }

}
