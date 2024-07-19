package com.jamjam.review.api;

import com.jamjam.review.api.request.CreateReviewRequest;
import com.jamjam.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewApi {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public void createReview(
            @RequestBody CreateReviewRequest request
            ){
        reviewService.createReview(request.getRestaurantId(), request.getContent(), request.getScore());
    }


    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") Long reviewId){
        reviewService.deleteReview(reviewId);

    }
}