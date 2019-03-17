package com.micro.services.api.gateway.service.client.ticketservice;

import com.micro.services.ticket.service.controller.HealthCheckController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ticketServiceClient")
public interface TicketServiceHealthCheckClient extends HealthCheckController {}
