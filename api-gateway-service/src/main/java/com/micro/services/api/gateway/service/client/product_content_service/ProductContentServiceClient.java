package com.micro.services.api.gateway.service.client.product_content_service;

import com.micro.services.api.gateway.service.config.FeignClientConfiguration;
import feign.Client;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;


@Import(FeignClientConfiguration.class)
@Component
public class ProductContentServiceClient {

    private static final String PRODUCT_CONTENT_SERVICE_NAME = "http://product-content-service";

    private HealthCheckClient healthCheckClient;

    private HeroSliderClient heroSliderClient;

    @Autowired
    public ProductContentServiceClient(Client client) {
        healthCheckClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .client(client)
                .contract(new SpringMvcContract())
                .target(HealthCheckClient.class, PRODUCT_CONTENT_SERVICE_NAME);

        heroSliderClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .client(client)
                .contract(new SpringMvcContract())
                .target(HeroSliderClient.class, PRODUCT_CONTENT_SERVICE_NAME);
    }

    public HealthCheckClient getHealthCheckClient() {
        return healthCheckClient;
    }

    public HeroSliderClient getHeroSliderClient() {
        return heroSliderClient;
    }
}
