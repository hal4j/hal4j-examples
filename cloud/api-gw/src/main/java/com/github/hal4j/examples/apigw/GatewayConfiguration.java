package com.github.hal4j.examples.apigw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hal4j.jackson.JacksonHALMapper;
import com.github.hal4j.jackson.JacksonResourceFactory;
import com.github.hal4j.resources.ResourceFactory;
import com.github.hal4j.spring.cloud.gw.ResourceResponseFilter;
import com.github.hal4j.uritemplate.ParamHolder;
import com.github.hal4j.uritemplate.URIFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Map;

import static com.github.hal4j.resources.cloud.DiscoveryClientLinkResolver.SERVICE_NS;
import static java.util.stream.Collectors.toMap;

@EnableZuulProxy
@EnableEurekaClient
public class GatewayConfiguration {

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

    @Bean
    public ResourceResponseFilter resourceResponseFilter(ResourceFactory factory,
                                                         JacksonHALMapper json,
                                                         DiscoveryClient client) {
        return new ResourceResponseFilter("api-gateway", factory, json, client);
    }

}
