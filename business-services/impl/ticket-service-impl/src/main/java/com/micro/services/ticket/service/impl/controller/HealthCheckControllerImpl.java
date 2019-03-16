package com.micro.services.ticket.service.impl.controller;

import com.micro.services.ticket.service.controller.HealthCheckController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckControllerImpl implements HealthCheckController {

    @GetMapping(value = "/ping")
    @Override
    public String ping() {
        return "pong";
    }

}
