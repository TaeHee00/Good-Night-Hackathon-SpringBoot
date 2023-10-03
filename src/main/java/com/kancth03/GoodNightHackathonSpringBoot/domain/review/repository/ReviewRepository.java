package com.kancth03.GoodNightHackathonSpringBoot.domain.review.repository;

import com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Long, Review> {
}
