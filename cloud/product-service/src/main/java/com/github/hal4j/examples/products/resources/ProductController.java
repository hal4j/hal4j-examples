package com.github.hal4j.examples.products.resources;

import com.github.hal4j.examples.products.repository.ProductsRepository;
import com.github.hal4j.examples.products.resources.model.Product;
import com.github.hal4j.resources.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping
public class ProductController {

    public static final String ID = "id";

    private final ProductsRepository products;
    private final ProductAssembler resource;

    public ProductController(ProductsRepository products, ProductAssembler resource) {
        this.products = products;
        this.resource = resource;
    }

    @GetMapping("/{" + ID + "}")
    public ResponseEntity<Resource<Product>> get(@PathVariable(ID) UUID uuid) {
        return products.get(uuid)
                .map(resource::create)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
