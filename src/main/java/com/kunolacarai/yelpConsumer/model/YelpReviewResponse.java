package com.kunolacarai.yelpConsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpReviewResponse {
    @Getter
    @Setter
    private List<YelpReview> reviews;

    @Getter
    @Setter
    private Integer total;

    @Override
    public String toString() {
        return "YelpReviewResponse{" +
                "reviews=" + reviews +
                ", total=" + total +
                '}';
    }
}
