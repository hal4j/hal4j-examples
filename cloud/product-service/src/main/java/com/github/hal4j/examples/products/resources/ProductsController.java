package com.github.hal4j.examples.products.resources;

import com.github.hal4j.examples.products.repository.ProductsRepository;
import com.github.hal4j.examples.products.resources.model.Product;
import com.github.hal4j.resources.Resource;
import com.github.hal4j.resources.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

import static com.github.hal4j.examples.products.discovery.LinkFactory.linkTo;
import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping(APIController.PATH + ProductsController.PATH)
public class ProductsController {

    public static final String PATH = "/products";

    public static final String REL_PRODUCTS_FIND_ALL = "products:find-all";

    private final ProductAssembler assembler;

    private final ProductsRepository products;

    public ProductsController(ProductAssembler resources, ProductsRepository products) {
        this.assembler = resources;
        this.products = products;
    }

    @GetMapping
    public Resources<Product> findAll() {
        Collection<Product> items = products.findAll();
        return assembler.factory()
                .bindAll(Product.class, items).to(linkTo(ProductsController.class))
                .as(assembler::create)
                .asResource();
    }

    @PostMapping
    public ResponseEntity<Resource<Product>> add(@RequestBody Product request) {
        Product product = products.save(request.assign(UUID.randomUUID()));
        Resource<Product> resource = assembler.create(product);
        return created(resource.self()).body(resource);
    }


}
