package com.kunolacarai.yelpConsumer.controller;

import com.kunolacarai.yelpConsumer.model.YelpConsumerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class YelpConsumerControllerTest {

    @Test
    public void testYelpResponse_noId() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080/yelpReview";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<List<YelpConsumerResponse>> request = new HttpEntity<>(headers);

        ResponseEntity<List> result = restTemplate.exchange(
                uri, HttpMethod.GET, request, List.class);
        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void testYelpResponse_withId() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080/yelpReview?id=16pyiWyaQXDXFXqqanAB6g";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<List<YelpConsumerResponse>> request = new HttpEntity<>(headers);

        ResponseEntity<List> result = restTemplate.exchange(
                uri, HttpMethod.GET, request, List.class);
        assertEquals(200, result.getStatusCodeValue());
    }
}