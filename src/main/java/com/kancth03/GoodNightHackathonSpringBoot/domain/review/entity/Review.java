package com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(nullable = false, length = 300)
    private String title;
    @Column(nullable = false, length = 10000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant_id;
}