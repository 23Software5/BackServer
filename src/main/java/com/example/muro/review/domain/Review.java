package com.example.muro.review.domain;

import com.example.muro.fh_request.domain.Fh_request;
import com.example.muro.funeralhall.domain.Funeralhall;
import com.example.muro.user.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "RegularReview")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "fhrequest_id")
    private Fh_request fh_request;

    @ManyToOne
    @JoinColumn(name = "fh_id")
    private Funeralhall funeralhall;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Column(name = "review_text")
    private String reviewText;

    @NotNull
    @Column(name = "startscore")
    private int startscore;

    // ... (다른 필드 및 메소드)
}
