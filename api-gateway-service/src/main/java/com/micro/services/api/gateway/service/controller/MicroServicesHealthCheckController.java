package com.micro.services.api.gateway.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class MicroServicesHealthCheckController {

//    @Autowired
//    private PCSHealthCheckClient pcsHealthCheckClient;
//
//    @Autowired
//    private USHealthCheckClient usHealthCheckClient;
//
//
//    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Map<String, String> checkAllApisHealthStatus() {
//        Map<String, String> healthCheckSummaries = new HashMap<>();
//
//        if (pcsHealthCheckClient.ping().equals("pong")) {
//            healthCheckSummaries.put("product-content-service", "alive");
//        } else  {
//            healthCheckSummaries.put("product-content-service", "dead");
//        }
//
//        if (usHealthCheckClient.ping().equals("pong")) {
//            healthCheckSummaries.put("user-service", "alive");
//        } else {
//            healthCheckSummaries.put("user-service", "dead");
//        }
//
//        return healthCheckSummaries;
//    }

}
