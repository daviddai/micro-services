package com.micro.services.api.gateway.service.client.userservice;

import com.micro.services.user.service.impl.controller.HealthCheckController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        value = "userServiceClient",
        fallback = UserServiceHealthCheckClient.UserServiceHealthCheckClientFallback.class
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
