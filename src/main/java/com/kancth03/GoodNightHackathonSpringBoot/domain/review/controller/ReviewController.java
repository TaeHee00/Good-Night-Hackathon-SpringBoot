package com.kancth03.GoodNightHackathonSpringBoot.domain.review.controller;

import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.*;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/review")
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 등록
    @PostMapping("/{restaurantId}")
    public AddReviewResponse addReview(@PathVariable Long restaurantId,
                                       @RequestBody AddReviewRequest request) {
        return reviewService.addReview(restaurantId, request);
    }

    // 리뷰 수정
    @PutMapping("/{reviewId}")
    public ModifyReviewResponse modifyReview(@PathVariable Long reviewId,
                                             @RequestBody ModifyReviewRequest request) {
        return reviewService.modifyReview(reviewId, request);
    }

    // 리뷰 삭제
    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
    }

    // 리뷰 단건 조회
    @GetMapping("/{reviewId}")
    public FindReviewResponse findReview(@PathVariable Long reviewId) {
        return reviewService.findReview(reviewId);
    }

    // 리뷰 목록 조회
    @GetMapping
    public List<RestaurantReview> findReviewList() {
        return reviewService.findReviewList();
    }
}
