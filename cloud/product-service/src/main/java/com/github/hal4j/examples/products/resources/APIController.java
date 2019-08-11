package com.github.hal4j.examples.products.resources;

import com.github.hal4j.resources.NavigationResource;
import com.github.hal4j.resources.ResourceFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.hal4j.examples.products.discovery.LinkFactory.linkTo;

@RestController
@RequestMapping(APIController.PATH)
public class APIController {

    public static final String PATH = "/api/v1";

    private final ResourceFactory resourceFactory;

    public APIController(ResourceFactory resourceFactory) {
        this.resourceFactory = resourceFactory;
    }

    @GetMapping
    public NavigationResource getEntry() {
        return resourceFactory.bindEntry().to(linkTo(APIController.class))
                .link(ProductsController.REL_PRODUCTS_FIND_ALL).to(linkTo(ProductsController.class))
                .asResource();
    }

}
