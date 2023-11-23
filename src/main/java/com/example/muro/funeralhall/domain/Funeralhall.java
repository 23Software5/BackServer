package com.example.muro.funeralhall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Funeralhall {
    @Id @GeneratedValue
    private Long fh_id;

    private String fh_name;
}
