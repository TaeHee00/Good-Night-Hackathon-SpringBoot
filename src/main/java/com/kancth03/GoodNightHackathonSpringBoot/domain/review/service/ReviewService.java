package com.kancth03.GoodNightHackathonSpringBoot.domain.review.service;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.repository.RestaurantRepository;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.AddReviewRequest;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.AddReviewResponse;
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
}
