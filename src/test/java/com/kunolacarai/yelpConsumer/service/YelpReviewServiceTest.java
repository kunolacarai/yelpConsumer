package com.kunolacarai.yelpConsumer.service;

import com.kunolacarai.yelpConsumer.model.YelpReviewResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

// TODO: Spend more time learning how to write JUnit Tests for Spring Boot programs.

@SpringBootTest
class YelpReviewServiceTest {
    private final RestTemplate restTemplate = new RestTemplate();
    private final YelpReviewService service = new YelpReviewService(restTemplate);

    @Test
    public void testGetReview() {
        // Since this is getting data from an outside source, the best I can test for is not null
        YelpReviewResponse response = service.getReview("16pyiWyaQXDXFXqqanAB6g");
        assertNotNull(response);
        System.out.println(response);
    }
}