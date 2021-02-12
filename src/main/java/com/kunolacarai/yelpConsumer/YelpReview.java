package com.kunolacarai.yelpConsumer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpReview {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String url;

    @Getter
    @Setter
    private Integer rating;

    @Getter
    @Setter
    private YelpUser user;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty("time_created")
    private Date timeCreated;

    @Override
    public String toString() {
        return "YelpReview{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", rating=" + rating +
                ", user=" + user +
                ", text='" + text + '\'' +
                ", timeCreated=" + timeCreated +
                '}';
    }
}
