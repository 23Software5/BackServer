package com.example.muro.fh_request.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Review {
    @Id @GeneratedValue
    private Long review_id;
    @OneToOne
    @JoinColumn(name = "fhrequest_id")
    private Fh_request fh_request;

}
