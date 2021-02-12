# yelpConsumer
Spring Boot practice using Yelp API

This one takes in URLs of the format:
http://{site}/yelpReview?id={id}
and returns an array of review details in the form of JSON objects. Future versions will make use of the Google Vision API to analyze the images of people.

Note: This retrieves the Yelp API Key from the evironmental variable YELP_API_KEY, so the user will need to provide that to test this.
