// ReviewController.java
package com.example.muro.review.controller;

import com.example.muro.review.domain.Review;
import com.example.muro.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public Review createReview(@RequestBody String content) {
        return reviewService.createReview(content);
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    // 후기 전체 조회 API
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // 추가적인 엔드포인트 및 기능을 필요에 따라 추가할 수 있습니다.
}
