package com.micro.services.user.service.impl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public interface HealthCheckController {

    @GetMapping(value = "/ping")
    String ping();

}
