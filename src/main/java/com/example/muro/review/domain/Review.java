// Review.java
package com.example.muro.review.domain;

import com.example.muro.user.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

//    @ManyToOne
//    @JoinColumn(name = "fhrequest_id")
//    private FuneralRequest funeralRequest;

    /*@ManyToOne
    @JoinColumn(name = "fh_id")
    private Funeralhall funeralhall;*/

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Column(name = "review_text")
    private String reviewText;

    @NotNull
    @Column(name = "startscore")
    private int startscore;

    // 생성자, 메소드 등을 추가할 수 있습니다.
}
