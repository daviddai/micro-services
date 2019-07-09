package com.micro.services.api.gateway.service.controller;

import com.micro.services.api.gateway.service.client.product_content_service.HeroSliderClient;
import com.micro.services.api.gateway.service.model.TravelExperienceHomeModel;
import com.micro.services.product.content.service.model.HeroSlider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController(value = "/travel-experience/home")
public class TravelExperienceHomeController {

    @Autowired
    private HeroSliderClient heroSliderClient;

    @GetMapping(value = "/data", produces = "application/json")
    public TravelExperienceHomeModel getHomeData() {
        List<HeroSlider> slides = heroSliderClient.getHeroSliders();
        return new TravelExperienceHomeModel.Builder()
                .withSlides(slides.stream().map(HeroSlider::getImageUrl).collect(Collectors.toList()))
                .build();
    }

}
