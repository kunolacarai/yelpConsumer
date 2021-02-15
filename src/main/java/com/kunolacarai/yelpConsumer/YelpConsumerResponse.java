package com.kunolacarai.yelpConsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpConsumerResponse {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @JsonProperty("image_url")
    private String imageUrl;

    @Getter
    @Setter
    private Integer rating;

    @Getter
    @Setter
    private String review;

    @Getter
    @Setter
    private List<GoogleVisionEmotion> emotions;

    @Override
    public String toString() {
        return "YelpConsumerResponse{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
