package com.micro.services.api.gateway.service.client.product_content_service;

import com.micro.services.api.gateway.service.config.FeignClientConfiguration;
import com.micro.services.product.content.service.controller.HealthCheckController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        // name has to be exactly the same the service name registered in Eureka
        name = "http://product-content-service-client",
        configuration = FeignClientConfiguration.class
)
public interface PCSHealthCheckClient extends HealthCheckController {}