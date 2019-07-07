package com.micro.services.api.gateway.service.controller;

import com.micro.services.api.gateway.service.client.product_content_service.ProductContentServiceHealthCheckClient;
import com.micro.services.api.gateway.service.client.user_service.UserServiceHealthCheckClient;
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
    private UserServiceHealthCheckClient userServiceHealthCheckClient;
    @Autowired
    private ProductContentServiceHealthCheckClient productContentServiceHealthCheckClient;


    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> checkAllApisHealthStatus() {
        Map<String, String> healthCheckSummaries = new HashMap<>();

        if (productContentServiceHealthCheckClient.ping().equals("pong")) {
            healthCheckSummaries.put("product-content-service", "alive");
        } else  {
            healthCheckSummaries.put("product-content-service", "dead");
        }

        if (userServiceHealthCheckClient.ping().equals("pong")) {
            healthCheckSummaries.put("user-service", "alive");
        } else {
            healthCheckSummaries.put("user-service", "dead");
        }

        return healthCheckSummaries;
    }

}
