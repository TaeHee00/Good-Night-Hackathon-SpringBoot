package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.RestaurantCategory;

import java.io.Serializable;

/**
 * DTO for {@link com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant}
 */
public record AddRestaurantRequest(
        String name,
        RestaurantCategory category
) {
}