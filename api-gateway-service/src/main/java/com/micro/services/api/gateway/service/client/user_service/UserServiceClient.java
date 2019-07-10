package com.micro.services.api.gateway.service.client.user_service;

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
public class UserServiceClient {

    private final static String USER_SERVICE_NAME = "http://user-service";

    private HealthCheckClient healthCheckClient;

    @Autowired
    public UserServiceClient(Client client, FeignClientConfiguration configuration) {
        healthCheckClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .client(client)
                .contract(new SpringMvcContract())
                // todo: need to fix logging level as it is not working now
                .logLevel(configuration.feignClientLoggerLevel())
                .target(HealthCheckClient.class, USER_SERVICE_NAME);
    }

    public HealthCheckClient getHealthCheckClient() {
        return healthCheckClient;
    }
}
