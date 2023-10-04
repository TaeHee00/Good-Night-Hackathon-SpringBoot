package com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto;

import com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review;

import java.util.ArrayList;
import java.util.List;

public record RestaurantReview(
        String restaurantName,
        List<ReviewInFindList> reviewList
) {

}
