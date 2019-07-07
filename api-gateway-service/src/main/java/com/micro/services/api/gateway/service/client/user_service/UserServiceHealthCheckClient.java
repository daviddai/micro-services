package com.micro.services.api.gateway.service.client.user_service;

import com.micro.services.api.gateway.service.config.FeignClientConfiguration;
import com.micro.services.user.service.impl.controller.HealthCheckController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        // name has to be exactly the same the service name registered in Eureka
        name = "user-service-client",
        fallback = UserServiceHealthCheckClient.UserServiceHealthCheckClientFallback.class,
        configuration = FeignClientConfiguration.class
)
public interface UserServiceHealthCheckClient extends HealthCheckController {

    @RequestMapping(value = "/user-service-health-check-fallback")
    @Component
    class UserServiceHealthCheckClientFallback implements HealthCheckController {

        @Override
        public String ping() {
            return "Fallback ping() in UserServiceHealthCheckClientFallback is called";
        }

    }

}
