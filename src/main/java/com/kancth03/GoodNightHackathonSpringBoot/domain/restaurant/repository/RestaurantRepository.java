package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.repository;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Long, Restaurant> {
}
