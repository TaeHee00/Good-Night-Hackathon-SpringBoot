package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.controller;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.AddRestaurantRequest;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.AddRestaurantResponse;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.ModifyCategoryRequest;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.ModifyRestaurantResponse;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/restaurant")
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    // 레스토랑 등록
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddRestaurantResponse addRestaurant(@RequestBody AddRestaurantRequest request) throws Exception {
        return restaurantService.addRestaurant(request);
    }

    // 레스토랑 카테고리 수정
    @PutMapping("/{id}")
    public ModifyRestaurantResponse modifyCategory(@PathVariable Long id, @RequestBody ModifyCategoryRequest request) {
        return restaurantService.modifyRestaurantCategory(id, request);
    }
}
