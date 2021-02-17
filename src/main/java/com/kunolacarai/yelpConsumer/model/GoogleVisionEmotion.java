package com.kunolacarai.yelpConsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleVisionEmotion {
    @Getter
    @Setter
    @JsonProperty("joy_likelihood")
    private String joyLikelihood;

    @Getter
    @Setter
    @JsonProperty("sorrow_likelihood")
    private String sorrowLikelihood;

    @Getter
    @Setter
    @JsonProperty("anger_likelihood")
    private String angerLikelihood;

    @Getter
    @Setter
    @JsonProperty("surprise_likelihood")
    private String surpriseLikelihood;

    @Override
    public String toString() {
        return "GoogleVisionEmotion{" +
                "joyLikelihood='" + joyLikelihood + '\'' +
                ", sorrowLikelihood='" + sorrowLikelihood + '\'' +
                ", angerLikelihood='" + angerLikelihood + '\'' +
                ", surpriseLikelihood='" + surpriseLikelihood + '\'' +
                '}';
    }
}
