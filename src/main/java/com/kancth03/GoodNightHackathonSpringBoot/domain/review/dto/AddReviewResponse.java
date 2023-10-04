package com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.ModifyRestaurantResponse;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review;

import java.io.Serializable;

/**
 * DTO for {@link com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review}
 */
public record AddReviewResponse(
        String title,
        String content,
        Long restaurant_id
) {
    public static AddReviewResponse entityToDto(Review review) {
        return new AddReviewResponse(review.getTitle(), review.getContent(), review.getRestaurant_id().getId());
    }
}