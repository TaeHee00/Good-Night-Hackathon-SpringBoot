package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity;

import com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
public class Restaurant {

    @Id
    @Column(nullable = false, updatable = false, name = "restaurant_id")
    private Long id;

    @Column(nullable = false, updatable = false, unique = true, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String category;

    @OneToMany(mappedBy = "restaurant_id")
    private List<Review> reviews = new ArrayList<>();
}
