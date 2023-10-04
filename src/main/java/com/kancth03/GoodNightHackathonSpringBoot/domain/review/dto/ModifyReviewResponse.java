package com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto;

import com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review;

import java.io.Serializable;

/**
 * DTO for {@link com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review}
 */
public record ModifyReviewResponse(
        String title,
        String content,
        Long restaurant_id
) {
    public static ModifyReviewResponse entityToDto(Review review) {
        return new ModifyReviewResponse(review.getTitle(), review.getContent(), review.getRestaurant_id().getId());
    }
}