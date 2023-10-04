package com.kancth03.GoodNightHackathonSpringBoot.domain.review.service;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.repository.RestaurantRepository;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.AddReviewRequest;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.AddReviewResponse;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.ModifyReviewRequest;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.ModifyReviewResponse;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public AddReviewResponse addReview(Long restaurantId, AddReviewRequest request) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("No restaurant exists that matches Id."));
        Review review = Review.of(request.title(), request.content(), restaurant);

        return AddReviewResponse.entityToDto(reviewRepository.save(review));
    }

    public ModifyReviewResponse modifyReview(Long reviewId, ModifyReviewRequest request) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("No review exists that matches Id."));

        if (request.title() != null) {
            review.setTitle(request.title());
        }
        if (request.content() != null) {
            review.setContent(request.content());
        }

        return ModifyReviewResponse.entityToDto(reviewRepository.save(review));
    }

    public void deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("No review exists that matches Id."));

        reviewRepository.delete(review);
    }
}
