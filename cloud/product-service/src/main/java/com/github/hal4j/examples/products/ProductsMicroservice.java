package com.github.hal4j.examples.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductsMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(ProductsMicroservice.class, args);
    }

}
