package com.kunolacarai.yelpConsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpUser {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    @JsonProperty("profile_url")
    private String profileUrl;

    @Getter
    @Setter
    @JsonProperty("image_url")
    private String imageUrl;

    @Getter
    @Setter
    private String name;

    @Override
    public String toString() {
        return "YelpUser{" +
                "id='" + id + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
