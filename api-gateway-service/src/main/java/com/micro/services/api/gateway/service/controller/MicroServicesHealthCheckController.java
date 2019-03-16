package com.micro.services.api.gateway.service.controller;

import com.micro.services.user.service.impl.controller.HealthCheckController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro-services/health")
public class MicroServicesHealthCheckController {

    private HealthCheckController userServiceHealthCheckController;
    private com.micro.services.ticket.service.controller.HealthCheckController ticketServiceHealthCheckController;

    @GetMapping(value = "/summary")
    public String checkAllApisHealthStatus() {
        String healthCheckSummary;

        if (userServiceHealthCheckController.ping().equals("pong")) {
            healthCheckSummary = "User service: alive";
        } else {
            healthCheckSummary = "User service: dead";
        }

        if (ticketServiceHealthCheckController.ping().equals("pong")) {
            healthCheckSummary += "\nTicket service: alive";
        } else  {
            healthCheckSummary += "\nTicket service: dead";
        }

        return healthCheckSummary;
    }

}
