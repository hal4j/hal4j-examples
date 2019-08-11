package com.github.hal4j.examples.products.discovery;

import com.github.hal4j.uritemplate.URIBuilder;

import static com.github.hal4j.spring.cloud.DiscoveryLinkBuilder.link;

public final class LinkFactory {

    public static final String SERVICE_ID = "products";

    public static URIBuilder linkTo(Class<?> controllerClass) {
        return link(SERVICE_ID).to(controllerClass);
    }

}
