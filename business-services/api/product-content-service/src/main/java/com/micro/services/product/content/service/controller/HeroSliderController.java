package com.micro.services.product.content.service.controller;

import com.micro.services.product.content.service.model.HeroSlider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/hero-slider")
public interface HeroSliderController {

    @GetMapping
    List<HeroSlider> getHeroSliders();

}
