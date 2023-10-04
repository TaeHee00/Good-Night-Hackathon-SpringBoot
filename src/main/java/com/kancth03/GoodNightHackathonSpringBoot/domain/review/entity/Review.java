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

    private Review(String title, String content, Restaurant restaurant_id) {
        this.title = title;
        this.content = content;
        this.restaurant_id = restaurant_id;
    }

    public static Review of(String title, String content, Restaurant restaurant_id) {
        return new Review(title, content, restaurant_id);
    }
}