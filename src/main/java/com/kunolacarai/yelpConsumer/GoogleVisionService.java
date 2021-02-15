package com.kunolacarai.yelpConsumer;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleVisionService {
    /*
    Modified some code from the Google Vision API, source:
    https://github.com/googleapis/java-vision/blob/master/samples/snippets/src/main/java/com/example/vision/snippets/DetectFacesGcs.java
     */
    public List<GoogleVisionEmotion> detectFacesGcs(String uri) throws IOException {
        List<AnnotateImageRequest> requests = new ArrayList<>();

        ImageSource imgSource = ImageSource.newBuilder().setImageUri(uri).build();
        Image img = Image.newBuilder().setSource(imgSource).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.FACE_DETECTION).build();

        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        List<GoogleVisionEmotion> results = new ArrayList<>();

        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                    return null;
                }

                // For full list of available annotations, see http://g.co/cloud/vision/docs
                for (FaceAnnotation annotation : res.getFaceAnnotationsList()) {
                    GoogleVisionEmotion emotion = new GoogleVisionEmotion();
                    emotion.setJoyLikelihood(annotation.getJoyLikelihood().toString());
                    emotion.setSorrowLikelihood(annotation.getSorrowLikelihood().toString());
                    emotion.setAngerLikelihood(annotation.getAngerLikelihood().toString());
                    emotion.setSurpriseLikelihood(annotation.getSurpriseLikelihood().toString());
                    results.add(emotion);
                }
            }
        }
        return results;
    }
}
