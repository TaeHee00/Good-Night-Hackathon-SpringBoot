package com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto;

import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * DTO for {@link com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review}
 */
public record ModifyReviewRequest(
        @Nullable
        String title,
        @Nullable
        String content
) {
}