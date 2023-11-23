package com.example.muro.fh_request.domain;

import com.example.muro.funeralhall.domain.Funeralhall;
import com.example.muro.user.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "fh_request")
public class Fh_request {
    @Id @GeneratedValue
    @Column(name = "fhrequest_id")
    private Long fhr_id;

    @ManyToOne
    @JoinColumn(name = "fh_id")
    private Funeralhall funeralhall;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User User;

    @OneToOne(mappedBy = "fh_request")
    private Review review;

    private FhRequestStatus status; //작성상태 [REQUEST,REVIEW]

}
