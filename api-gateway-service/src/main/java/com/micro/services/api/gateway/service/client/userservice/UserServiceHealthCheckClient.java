package com.micro.services.api.gateway.service.client.userservice;

import com.micro.services.user.service.impl.controller.HealthCheckController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "userServiceClient")
public interface UserServiceHealthCheckClient extends HealthCheckController {}
