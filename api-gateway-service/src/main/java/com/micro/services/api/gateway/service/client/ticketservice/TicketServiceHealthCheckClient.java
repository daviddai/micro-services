package com.micro.services.api.gateway.service.client.ticketservice;

import com.micro.services.ticket.service.controller.HealthCheckController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        value = "ticketServiceClient",
        fallback = TicketServiceHealthCheckClient.TicketServiceHealthCheckClientFallback.class
)
public interface TicketServiceHealthCheckClient extends HealthCheckController {

    @RequestMapping(value = "ticket-service-health-check-fall-back")
    @Component
    class TicketServiceHealthCheckClientFallback implements HealthCheckController {

        @Override
        public String ping() {
            return "Fallback ping() in TicketServiceHealthCheckClientFallback is called";
        }

    }

}
