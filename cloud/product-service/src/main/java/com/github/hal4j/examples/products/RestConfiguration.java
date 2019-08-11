package com.github.hal4j.examples.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hal4j.jackson.JacksonHALMapper;
import com.github.hal4j.jackson.JacksonResourceFactory;
import com.github.hal4j.resources.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RestConfiguration {

    @Bean
    public JacksonHALMapper jacksonMapper() {
        return new JacksonHALMapper();
    }

    @Primary
    @Bean
    public ObjectMapper objectMapper(JacksonHALMapper jackson) {
        return jackson.mapper();
    }

    @Bean
    public ResourceFactory resourceFactory(JacksonHALMapper mapper) {
        return new JacksonResourceFactory(mapper);
    }

}
