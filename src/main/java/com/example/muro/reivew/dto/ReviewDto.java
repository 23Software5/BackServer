// ReviewDto.java
package com.example.muro.reivew.dto;

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

    // 생성자, 변환 메소드 등을 추가할 수 있습니다.
}
