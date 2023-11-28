package com.example.muro.fh_request.dto;

import com.example.muro.funeralhall.domain.Funeralhall;

import java.util.Date;

public class Fh_RequestDto {

    private Long fhr_id;

    private Funeralhall funeralhall;


    private String pet_name;

    private Long pet_weight;

    private String pet_species;

    private Date fh_date;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}



