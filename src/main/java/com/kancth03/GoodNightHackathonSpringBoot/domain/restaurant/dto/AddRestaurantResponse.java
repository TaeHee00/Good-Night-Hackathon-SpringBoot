package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.RestaurantCategory;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant}
 */
public record AddRestaurantResponse(
        Long id,
        String name,
        RestaurantCategory category,
        LocalDateTime createdAt) {

    public static AddRestaurantResponse entityToDto(Restaurant restaurant) {
        return new AddRestaurantResponse(restaurant.getId(), restaurant.getName(), restaurant.getCategory(), restaurant.getCreatedAt());
    }
}