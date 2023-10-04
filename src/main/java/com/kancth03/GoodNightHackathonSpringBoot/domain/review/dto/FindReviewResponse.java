package com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto;

import com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review;
import lombok.Getter;

public record FindReviewResponse (
        String restaurantName,
        String title,
        String content
){
    public static FindReviewResponse entityToDto(Review review) {
        return new FindReviewResponse(review.getRestaurant_id().getName(), review.getTitle(), review.getContent());
    }
}
