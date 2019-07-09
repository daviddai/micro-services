package com.micro.services.product.content.service.model;

public class HeroSlider {

    private String imageUrl;

    public HeroSlider() {}

    public HeroSlider(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
