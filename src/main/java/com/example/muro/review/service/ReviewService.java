package com.example.muro.review.service;

import com.example.muro.fh_request.domain.Fh_Request;
import com.example.muro.fh_request.repository.Fh_RequestRepository;
import com.example.muro.review.domain.Review;
import com.example.muro.review.dto.ReviewDto;
import com.example.muro.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private Fh_RequestRepository fhRequestRepository;

    public Review createReview(ReviewDto reviewDto) {
        // Review 객체를 생성할 때 필요한 인자를 제공하는 생성자 사용
        Review review = new Review(
                null, // Fh_Request 객체는 따로 생성하여 설정
                null, // Funeralhall 객체는 따로 설정
                null, // Users 객체는 따로 설정
                reviewDto.getReviewText(),
                reviewDto.getStartscore()
        );

        // 외래키 설정
        Fh_Request fhRequest = fhRequestRepository.findById(reviewDto.getFhRequestId()).orElse(null);
        if (fhRequest != null) {
            review.setFh_request(fhRequest);
            review.setFuneralhall(fhRequest.getFuneralhall());
            review.setUser(fhRequest.getUser());
        }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
