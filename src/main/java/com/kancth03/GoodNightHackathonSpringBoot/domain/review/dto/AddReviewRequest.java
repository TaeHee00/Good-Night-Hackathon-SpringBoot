package com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review}
 */
public record AddReviewRequest(
        String title,
        String content
) {
}