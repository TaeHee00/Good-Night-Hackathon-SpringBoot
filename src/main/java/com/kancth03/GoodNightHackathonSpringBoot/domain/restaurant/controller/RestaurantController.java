package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.controller;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.AddRestaurantRequest;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.dto.AddRestaurantResponse;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/restaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public AddRestaurantResponse addRestaurant(@RequestBody AddRestaurantRequest request) throws Exception {
        return restaurantService.addRestaurant(request);
    }
}
