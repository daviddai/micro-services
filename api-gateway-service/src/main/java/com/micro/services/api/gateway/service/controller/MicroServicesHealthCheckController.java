package com.micro.services.api.gateway.service.controller;

import com.micro.services.api.gateway.service.client.ticketservice.TicketServiceHealthCheckClient;
import com.micro.services.api.gateway.service.client.userservice.UserServiceHealthCheckClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micro-services/health")
public class MicroServicesHealthCheckController {

    @Autowired
    private UserServiceHealthCheckClient userServiceHealthCheckClient;
    @Autowired
    private TicketServiceHealthCheckClient ticketServiceHealthCheckClient;


    @GetMapping(value = "/summary")
    public String checkAllApisHealthStatus() {
        String healthCheckSummary;

        if (ticketServiceHealthCheckClient.ping().equals("pong")) {
            healthCheckSummary = "Ticket service: alive";
        } else  {
            healthCheckSummary = "Ticket service: dead";
        }

        if (userServiceHealthCheckClient.ping().equals("pong")) {
            healthCheckSummary += "\nUser service: alive";
        } else {
            healthCheckSummary += "\nUser service: dead";
        }

        return healthCheckSummary;
    }

}
