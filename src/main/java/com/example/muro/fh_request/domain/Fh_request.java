package com.example.muro.fh_request.domain;

import com.example.muro.funeralhall.domain.Funeralhall;
import com.example.muro.user.domain.Users;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fh_request")
@SequenceGenerator(name = "fhr_seq", sequenceName = "fhr_seq", initialValue = 100, allocationSize = 1)
public class Fh_Request {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fhr_seq")
    @Column(name = "fhrequest_id")
    private Long fhr_id;

    @ManyToOne
    @JoinColumn(name = "fh_id")
    private Funeralhall funeralhall;

    private String pet_name;

    private Long pet_weight;

    private String pet_species;

    private Date fh_date;

    private String fr_text;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Enumerated(EnumType.STRING)
    private FhRequestStatus status = FhRequestStatus.REQUEST; // 초기값을 REQUEST로 설정



    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getFhr_id() {
        return fhr_id;
    }
}