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

    public void setFhr_id(Long fhr_id) {
        this.fhr_id = fhr_id;
    }

    // funeralhall Getter 및 Setter
    public Funeralhall getFuneralhall() {
        return funeralhall;
    }

    public void setFuneralhall(Funeralhall funeralhall) {
        this.funeralhall = funeralhall;
    }



    // status Getter 및 Setter
    public FhRequestStatus getStatus() {
        return status;
    }

    public void setStatus(FhRequestStatus status) {
        this.status = status;
    }

    // pet_name Getter 및 Setter
    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    // pet_weight Getter 및 Setter
    public Long getPet_weight() {
        return pet_weight;
    }

    public void setPet_weight(Long pet_weight) {
        this.pet_weight = pet_weight;
    }

    // pet_species Getter 및 Setter
    public String getPet_species() {
        return pet_species;
    }

    public void setPet_species(String pet_species) {
        this.pet_species = pet_species;
    }

    // fh_date Getter 및 Setter
    public Date getFh_date() {
        return fh_date;
    }

    public void setFh_date(Date fh_date) {
        this.fh_date = fh_date;
    }


    public String getFr_text() {
        return fr_text;
    }

    public void setFr_text(String fr_text) {
        this.fr_text = fr_text;
    }
}
//오류 삭제