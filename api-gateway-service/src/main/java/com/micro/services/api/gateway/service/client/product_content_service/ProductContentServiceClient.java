package com.micro.services.api.gateway.service.client.product_content_service;

import com.micro.services.api.gateway.service.config.FeignClientConfiguration;
import feign.Client;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.stereotype.Component;


@Component
public class ProductContentServiceClient {

    private static final String PRODUCT_CONTENT_SERVICE_NAME = "http://product-content-service";

    private HealthCheckClient healthCheckClient;

    private HeroSliderClient heroSliderClient;

    private DestinationClient destinationClient;

    @Autowired
    public ProductContentServiceClient(Client client, FeignClientConfiguration configuration) {
        healthCheckClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .client(client)
                .contract(new SpringMvcContract())
                // todo: need to fix logging level as it is not working now
                .logLevel(configuration.feignClientLoggerLevel())
                .target(HealthCheckClient.class, PRODUCT_CONTENT_SERVICE_NAME);

        heroSliderClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .client(client)
                .contract(new SpringMvcContract())
                // todo: need to fix logging level as it is not working now
                .logLevel(configuration.feignClientLoggerLevel())
                .target(HeroSliderClient.class, PRODUCT_CONTENT_SERVICE_NAME);

        destinationClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .client(client)
                .contract(new SpringMvcContract())
                // todo: need to fix logging level as it is not working now
                .logLevel(configuration.feignClientLoggerLevel())
                .target(DestinationClient.class, PRODUCT_CONTENT_SERVICE_NAME);
    }

    public HealthCheckClient getHealthCheckClient() {
        return healthCheckClient;
    }

    public HeroSliderClient getHeroSliderClient() {
        return heroSliderClient;
    }

    public DestinationClient getDestinationClient() {
        return destinationClient;
    }
}
