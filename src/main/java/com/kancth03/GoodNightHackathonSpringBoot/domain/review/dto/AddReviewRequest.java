package com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto;


/**
 * DTO for {@link com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review}
 */
public record AddReviewRequest(
        String title,
        String content
) {
}