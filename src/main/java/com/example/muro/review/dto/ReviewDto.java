// ReviewDto.java
package com.example.muro.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {

    private Long reviewId;
    private Long fhRequestId;  // 외래키
    private Long fhId;         // 외래키
    private Long userId;       // 외래키
    private String reviewText;
    private int startscore;


}
