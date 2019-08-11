package com.github.hal4j.examples.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GatewayConfiguration.class)
public class APIGatewayMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(APIGatewayMicroservice.class, args);
    }

}
