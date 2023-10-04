package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.controller;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.*;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.RestaurantCategory;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ModifyRestaurantResponse modifyCategory(@PathVariable Long id,
                                                   @RequestBody ModifyCategoryRequest request) {
        return restaurantService.modifyRestaurantCategory(id, request);
    }

    // 레스토랑 단건 조회
    @GetMapping("/{id}")
    public FindRestaurantResponse findRestaurant(@PathVariable Long id) {
        return restaurantService.findRestaurant(id);
    }

    // 레스토랑 목록 조회
    @GetMapping
    public List<FindRestaurantResponse> findRestaurantList(@RequestParam(name = "category", required = false)RestaurantCategory category) {
        if (category != null) {
            return restaurantService.findRestaurantList(category);
        }
        return restaurantService.findRestaurantList();
    }
}
