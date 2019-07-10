package com.micro.services.product.content.service.controller;

import com.micro.services.product.content.service.model.TopDestination;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/destination")
public interface DestinationController {

    @GetMapping(value = "/top")
    List<TopDestination> getTopDestinations();

}
