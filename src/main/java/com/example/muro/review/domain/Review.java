package com.example.muro.review.domain;

import com.example.muro.fh_request.domain.Fh_Request;
import com.example.muro.funeralhall.domain.Funeralhall;
import com.example.muro.user.domain.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "Review")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "fhrequest_id")
    private Fh_Request fh_request;

    @ManyToOne
    @JoinColumn(name = "fh_id")
    private Funeralhall funeralhall;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @NotBlank
    @Column(name = "review_text")
    private String reviewText;

    @NotNull
    @Column(name = "startscore")
    private int startscore;
    public Review(Fh_Request fhRequest, Funeralhall funeralhall, Users user, String reviewText, int startscore) {
        this.fh_request = fhRequest;
        this.funeralhall = funeralhall;
        this.user = user;
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


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Fh_Request setFh_request(Fh_Request fhRequest) {
        return fh_request;
    }

    public void setFhRequest(Fh_Request fhRequest) {
        this.fh_request = fh_request;
    }

    public void setFuneralhall(Funeralhall funeralhall) {
        this.funeralhall = funeralhall;
    }
}


    // 생성자, 메소드 등을 추가할 수 있습니다.

