package com.micro.services.api.gateway.service.controller;

import com.micro.services.api.gateway.service.client.product_content_service.ProductContentServiceClient;
import com.micro.services.api.gateway.service.model.TravelExperienceHomeModel;
import com.micro.services.product.content.service.model.HeroSlider;
import com.micro.services.product.content.service.model.TopDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/travel-experience/home")
public class TravelExperienceHomeController {

    @Autowired
    private ProductContentServiceClient productContentServiceClient;

    @GetMapping(value = "/data", produces = "application/json")
    public TravelExperienceHomeModel getHomeData() {
        List<HeroSlider> slides = productContentServiceClient.getHeroSliderClient().getHeroSliders();
        List<TopDestination> topDestinations = productContentServiceClient.getDestinationClient().getTopDestinations();

        return new TravelExperienceHomeModel.Builder()
                .withSlides(slides.stream().map(HeroSlider::getImageUrl).collect(Collectors.toList()))
                .withTopDestinations(topDestinations)
                .build();
    }

}
