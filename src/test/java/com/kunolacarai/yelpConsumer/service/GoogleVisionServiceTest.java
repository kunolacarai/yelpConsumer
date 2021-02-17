package com.kunolacarai.yelpConsumer.service;

import com.kunolacarai.yelpConsumer.model.GoogleVisionEmotion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoogleVisionServiceTest {
    private final GoogleVisionService googleVisionService = new GoogleVisionService();

    @Test
    public void testDetectFacesGcs() throws IOException {
        List<GoogleVisionEmotion> emotionList = googleVisionService.detectFacesGcs("https://s3-media2.fl.yelpcdn.com/photo/WRaNUjvMPZfm-RJITn3Xzw/o.jpg");
        assertNotNull(emotionList);
        System.out.println(emotionList);
    }
}