package com.micro.services.api.gateway.service.controller;

import com.micro.services.api.gateway.service.client.product_content_service.ProductContentServiceClient;
import com.micro.services.api.gateway.service.client.user_service.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class MicroServicesHealthCheckController {

    @Autowired
    private ProductContentServiceClient productContentServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;


    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> checkAllApisHealthStatus() {
        Map<String, String> healthCheckSummaries = new HashMap<>();

        if (productContentServiceClient.getHealthCheckClient().ping().equals("pong")) {
            healthCheckSummaries.put("product-content-service", "alive");
        } else  {
            healthCheckSummaries.put("product-content-service", "dead");
        }

        if (userServiceClient.getHealthCheckClient().ping().equals("pong")) {
            healthCheckSummaries.put("user-service", "alive");
        } else {
            healthCheckSummaries.put("user-service", "dead");
        }

        return healthCheckSummaries;
    }

}
