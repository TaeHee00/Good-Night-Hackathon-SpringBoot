package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.RestaurantCategory;

import java.time.LocalDateTime;

/**
 * DTO for {@link Restaurant}
 */
public record ModifyRestaurantResponse(
        String name,
        RestaurantCategory category) {

    public static ModifyRestaurantResponse entityToDto(Restaurant restaurant) {
        return new ModifyRestaurantResponse(restaurant.getName(), restaurant.getCategory());
    }
}