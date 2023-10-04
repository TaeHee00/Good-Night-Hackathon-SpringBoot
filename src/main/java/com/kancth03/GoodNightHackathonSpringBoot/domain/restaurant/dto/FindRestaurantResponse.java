package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.RestaurantCategory;
import lombok.Getter;

import java.time.LocalDateTime;

public record FindRestaurantResponse (
        String name,
        RestaurantCategory category,
        LocalDateTime createdAt
){

    public static FindRestaurantResponse entityToDto(Restaurant restaurant) {
        return new FindRestaurantResponse(restaurant.getName(), restaurant.getCategory(), restaurant.getCreatedAt());
    }
}
