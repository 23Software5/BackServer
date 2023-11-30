package com.example.muro.review.dto;

import lombok.Getter;
import lombok.Setter;


public class ReviewDto {

    private Long fhRequestId;
    private Long userId;
    private String reviewText;
    private int startscore;

    public ReviewDto(Long fhRequestId, Long userId, String reviewText, int startscore) {
        this.fhRequestId = fhRequestId;
        this.userId = userId;
        this.reviewText = reviewText;
        this.startscore = startscore;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getStartscore() {
        return startscore;
    }

    public void setStartscore(int startscore) {
        this.startscore = startscore;
    }

    public Long getFhRequestId() {
        return fhRequestId;
    }

    public void setFhRequestId(Long fhRequestId) {
        this.fhRequestId = fhRequestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
