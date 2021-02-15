package com.kunolacarai.yelpConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class YelpConsumerController {

    private final YelpReviewService yelpReviewService;

    private final GoogleVisionService googleVisionService;

    @Autowired
    public YelpConsumerController(YelpReviewService yelpReviewService, GoogleVisionService googleVisionService) {
        this.yelpReviewService = yelpReviewService;
        this.googleVisionService = googleVisionService;
    }

    @GetMapping("/yelpReview")
    public List<YelpConsumerResponse> yelpResponse(@RequestParam(value = "id", defaultValue = "16pyiWyaQXDXFXqqanAB6g") String id) {
        YelpReviewResponse yelpReviewResponse = yelpReviewService.getReview(id);
        List<YelpConsumerResponse> returnValue = new ArrayList<>();
        for (YelpReview review : yelpReviewResponse.getReviews()) {
            YelpConsumerResponse response = new YelpConsumerResponse();
            response.setName(review.getUser().getName());
            response.setImageUrl(review.getUser().getImageUrl());
            response.setRating(review.getRating());
            response.setReview(review.getText());
            try {
                response.setEmotions(googleVisionService.detectFacesGcs(review.getUser().getImageUrl()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            returnValue.add(response);
        }
        return returnValue;
    }

}
