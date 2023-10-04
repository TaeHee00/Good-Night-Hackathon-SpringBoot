package com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto;

import com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review;

public record ReviewInFindList(
        String title,
        String content
) {
    public static ReviewInFindList entityToDto(Review review) {
        return new ReviewInFindList(review.getTitle(), review.getContent());
    }
}
