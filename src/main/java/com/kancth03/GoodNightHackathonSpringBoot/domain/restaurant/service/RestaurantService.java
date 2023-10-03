package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.service;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.AddRestaurantRequest;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.AddRestaurantResponse;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.RestaurantCategory;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.repository.RestaurantRepository;
import com.kancth03.GoodNightHackathonSpringBoot.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public AddRestaurantResponse addRestaurant(AddRestaurantRequest request) throws Exception {
        Restaurant newRestaurant = Restaurant.of(request.name(), request.category());
        // 레스토랑명 중복 확인
        if (restaurantRepository.findByName(request.name()).isEmpty()) {
            // 중복되는 레스토랑명이 없는 경우
            Restaurant addRestaurant = restaurantRepository.save(newRestaurant);
            return AddRestaurantResponse.entityToDto(addRestaurant);
        }

        throw new Exception("Restaurant name is duplicated.");
    }
}
