package com.micro.services.api.gateway.service.client.product_content_service;

import com.micro.services.api.gateway.service.config.FeignClientConfiguration;
import com.micro.services.product.content.service.controller.HealthCheckController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        // name has to be exactly the same the service name registered in Eureka
        name = "product-content-service-client",
        fallback = ProductContentServiceHealthCheckClient.ProductContentServiceHealthCheckClientFallback.class,
        configuration = FeignClientConfiguration.class
)
public interface ProductContentServiceHealthCheckClient extends HealthCheckController {

    @RequestMapping(value = "product-content-service-health-check-fall-back")
    @Component
    class ProductContentServiceHealthCheckClientFallback implements HealthCheckController {

        @Override
        public String ping() {
            return "Fallback ping() in ProductContentServiceHealthCheckClientFallback is called";
        }

    }

}
