package com.example.muro.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
