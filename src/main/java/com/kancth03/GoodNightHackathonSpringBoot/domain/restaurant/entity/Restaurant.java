package com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity;

import com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table
@Getter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    @Column(nullable = false, updatable = false, unique = true, length = 100)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RestaurantCategory category;

    @OneToMany(mappedBy = "restaurant_id")
    private List<Review> reviews = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    private Restaurant(String name, RestaurantCategory category) {
        this.name = name;
        this.category = category;
    }

    public static Restaurant of(String name, RestaurantCategory category) {
        return new Restaurant(name, category);
    }
}
