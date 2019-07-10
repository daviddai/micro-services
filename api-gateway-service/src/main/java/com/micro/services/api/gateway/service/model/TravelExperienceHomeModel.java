package com.micro.services.api.gateway.service.model;

import com.micro.services.product.content.service.model.TopDestination;

import java.util.List;

public class TravelExperienceHomeModel {

    private List<String> slides;

    private List<TopDestination> topDestinations;

    private TravelExperienceHomeModel() {}

    public List<String> getSlides() {
        return slides;
    }

    public List<TopDestination> getTopDestinations() {
        return topDestinations;
    }

    public static class Builder {
        private TravelExperienceHomeModel model;

        public Builder() {
            model = new TravelExperienceHomeModel();
        }

        public Builder withSlides(List<String> slides) {
            this.model.slides = slides;
            return this;
        }

        public Builder withTopDestinations(List<TopDestination>  topDestinations) {
            this.model.topDestinations = topDestinations;
            return this;
        }

        public TravelExperienceHomeModel build() {
            return this.model;
        }
    }
}
