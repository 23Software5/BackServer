package com.example.muro.review.controller;

import com.example.muro.review.domain.Review;
import com.example.muro.review.dto.ReviewDto;
import com.example.muro.review.service.ReviewService;
import com.example.muro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;


    @GetMapping("/{userId}/all")
    public ResponseEntity<List<Review>> getReviewsByUserId(@PathVariable Long userId) {
        try {
            List<Review> reviews = userService.getReviewsByUserId(userId);
            return ResponseEntity.ok(reviews);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestBody ReviewDto reviewDto) {
        try {
            reviewService.createReview(reviewDto);
            return ResponseEntity.ok("리뷰 생성 성공");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("리뷰를 생성하는 중에 오류 발생");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        return review != null ?
                new ResponseEntity<>(review, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
}
