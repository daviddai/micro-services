package com.micro.services.api.gateway.service.model;

import java.util.List;

public class TravelExperienceHomeModel {

    private List<String> slides;

    private TravelExperienceHomeModel() {}

    public List<String> getSlides() {
        return slides;
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

        public TravelExperienceHomeModel build() {
            return this.model;
        }
    }
}
