package com.github.hal4j.examples.products.resources;

import com.github.hal4j.examples.products.resources.ProductController;
import com.github.hal4j.examples.products.resources.model.Product;
import com.github.hal4j.resources.Resource;
import com.github.hal4j.resources.ResourceFactory;
import org.springframework.stereotype.Component;

import static com.github.hal4j.examples.products.discovery.LinkFactory.linkTo;
import static com.github.hal4j.examples.products.resources.model.Product.REL_DELETE;
import static com.github.hal4j.examples.products.resources.model.Product.REL_UPDATE;

@Component
public class ProductAssembler {

    private final ResourceFactory factory;

    public ProductAssembler(ResourceFactory factory) {
        this.factory = factory;
    }

    public ResourceFactory factory() {
        return this.factory;
    }

    public Resource<Product> create(Product product) {
        return factory.bind(product).to(linkTo(ProductController.class))
                .link(REL_DELETE).to(linkTo(ProductController.class))
                .link(REL_UPDATE).to(linkTo(ProductController.class))
                .asResource();
    }
}
