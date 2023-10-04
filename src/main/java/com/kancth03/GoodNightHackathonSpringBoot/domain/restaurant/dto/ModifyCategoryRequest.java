package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.RestaurantCategory;
import lombok.Getter;

@Getter
public class ModifyCategoryRequest {
    private RestaurantCategory category;
}
