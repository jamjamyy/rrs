package com.jamjam.review.service;


import com.jamjam.review.model.ReviewEntity;
import com.jamjam.review.repository.RestaurantRepository;
import com.jamjam.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.ZonedDateTime;


@RequiredArgsConstructor
@Service
public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;


    @Transactional
    public void createReview(
            Long restaurantId, String content, Double score
    ){
        restaurantRepository.findById(restaurantId).orElseThrow();

        ReviewEntity review = ReviewEntity.builder().
        restaurantId(restaurantId).content(content).score(score).createdAt(ZonedDateTime.now())
        .build();

        reviewRepository.save(review);
    }

    // 삭제
    @Transactional
    public void deleteReview(Long reviewId){
        ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();

        reviewRepository.delete(review);
    }
}
