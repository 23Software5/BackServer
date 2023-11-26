// ReviewService.java
package com.example.muro.review.service;

import com.example.muro.review.domain.Review;
import com.example.muro.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(String content) {
        Review review = new Review();
        /*review.setReviewText(content);
        // startscore에 디폴트 값 또는 사용자 입력값을 설정해야 합니다.
        review.setStartscore(0); // 예시로 0으로 설정했습니다.
        return reviewRepository.save(review);*/
        return review;
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    // 후기 전체 조회 메서드
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // 추가적인 조회 로직이나 업데이트 로직을 필요에 따라 추가할 수 있습니다.
}
