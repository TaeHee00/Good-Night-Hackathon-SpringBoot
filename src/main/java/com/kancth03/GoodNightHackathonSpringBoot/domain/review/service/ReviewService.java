package com.kancth03.GoodNightHackathonSpringBoot.domain.review.service;

import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.entity.Restaurant;
import com.kancth03.GoodNightHackathonSpringBoot.domain.restaurant.repository.RestaurantRepository;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.dto.*;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.entity.Review;
import com.kancth03.GoodNightHackathonSpringBoot.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public AddReviewResponse addReview(Long restaurantId, AddReviewRequest request) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("No restaurant exists that matches Id."));
        Review review = Review.of(request.title(), request.content(), restaurant);

        return AddReviewResponse.entityToDto(reviewRepository.save(review));
    }

    public ModifyReviewResponse modifyReview(Long reviewId, ModifyReviewRequest request) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("No review exists that matches Id."));

        if (request.title() != null) {
            review.setTitle(request.title());
        }
        if (request.content() != null) {
            review.setContent(request.content());
        }

        return ModifyReviewResponse.entityToDto(reviewRepository.save(review));
    }

    public void deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("No review exists that matches Id."));

        reviewRepository.delete(review);
    }

    public FindReviewResponse findReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("No review exists that matches Id."));

        return FindReviewResponse.entityToDto(review);
    }


    //레스토랑 명, 리뷰 리스트를 내용을 반환합니다.
    //리뷰 리스트는 등록 순이나 역순으로 조회할 수 있고 pagination을 지원하며, 리뷰 제목과 내용으로 검색할 수 있습니다.
    public List<RestaurantReview> findReviewList() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurant -> {
                    List<ReviewInFindList> reviewList = restaurant.getReviews()
                            .stream()
                            .map(ReviewInFindList::entityToDto)
                            .toList();
                    return new RestaurantReview(restaurant.getName(), reviewList);})
                .toList();
    }
}
