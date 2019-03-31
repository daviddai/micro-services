package com.micro.services.api.gateway.service.controller;

import com.micro.services.api.gateway.service.client.ticketservice.TicketServiceHealthCheckClient;
import com.micro.services.api.gateway.service.client.userservice.UserServiceHealthCheckClient;
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
    private TicketServiceHealthCheckClient ticketServiceHealthCheckClient;


    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> checkAllApisHealthStatus() {
        Map<String, String> healthCheckSummaries = new HashMap<>();

        if (ticketServiceHealthCheckClient.ping().equals("pong")) {
            healthCheckSummaries.put("ticket-service", "alive");
        } else  {
            healthCheckSummaries.put("ticket-service", "dead");
        }

        if (userServiceHealthCheckClient.ping().equals("pong")) {
            healthCheckSummaries.put("user-service", "alive");
        } else {
            healthCheckSummaries.put("user-service", "dead");
        }

        return healthCheckSummaries;
    }

}
