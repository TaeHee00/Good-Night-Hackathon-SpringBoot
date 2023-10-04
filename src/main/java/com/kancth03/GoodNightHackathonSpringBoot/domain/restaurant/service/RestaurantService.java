package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.service;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.*;
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

    public ModifyRestaurantResponse modifyRestaurantCategory(Long restaurantId, ModifyCategoryRequest request) {
        // restaurantId에 해당하는 레스토랑이 있는지 확인
        Restaurant findRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("No restaurant exists that matches Id."));

        findRestaurant.setCategory(request.getCategory());
        // 쿼리 확인을 위해 save 메서드를 사용하여 쿼리가 나가도록 함
        return ModifyRestaurantResponse.entityToDto(restaurantRepository.save(findRestaurant));
    }

    public FindRestaurantResponse findRestaurant(Long restaurantId) {
        Restaurant findRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("No restaurant exists that matches Id."));

        return FindRestaurantResponse.entityToDto(findRestaurant);
    }
}
