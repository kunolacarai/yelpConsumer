package com.kunolacarai.yelpConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class YelpReviewService {
    public static final String YELP_API_KEY = System.getenv("YELP_API_KEY");

    @Autowired
    private RestTemplate restTemplate;

    public YelpReviewResponse getReview(String id) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set("Authorization", "Bearer " + YELP_API_KEY);

        HttpEntity<YelpReviewResponse> request = new HttpEntity<>(headers);

        ResponseEntity<YelpReviewResponse> response = restTemplate.exchange(
                "https://api.yelp.com/v3/businesses/"+id+"/reviews",
                HttpMethod.GET,
                request,
                YelpReviewResponse.class
        );

        return response.getBody();
    }
}
