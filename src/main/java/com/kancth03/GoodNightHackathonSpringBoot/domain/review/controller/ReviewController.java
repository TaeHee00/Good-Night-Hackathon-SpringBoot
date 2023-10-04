package com.kancth03.GoodNightHackathonSpringBoot.domain.review.controller;

import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.AddReviewRequest;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.AddReviewResponse;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.ModifyReviewRequest;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.ModifyReviewResponse;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
