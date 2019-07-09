package com.micro.services.product.content.service.impl.controller;

import com.micro.services.product.content.service.controller.HeroSliderController;
import com.micro.services.product.content.service.model.HeroSlider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController(value = "/hero-slider")
public class HeroSliderControllerImpl implements HeroSliderController {

    @Override
    @GetMapping
    public List<HeroSlider> getHeroSliders() {
        List<String> heroSliderImageUrls = Arrays.asList("/images/banner-image-1.jpg", "/images/banner-image-2.jpg");
        return heroSliderImageUrls.stream()
                .map(HeroSlider::new)
                .collect(Collectors.toList());
    }
}
