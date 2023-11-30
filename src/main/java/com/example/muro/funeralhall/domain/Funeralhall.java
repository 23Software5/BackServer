// Funeralhall.java
package com.example.muro.funeralhall.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Funeralhall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fh_id;

    @NotBlank
    private String fh_name;

    @NotBlank
    private String fh_location;

    private String fh_link;

    private String fh_telephone;

    private String fh_intro;

    // 새로운 필드 추가
    @NotBlank
    private String fh_type;

    // 생성자, getter, setter 등이 있어야 합니다.

    public Long getFh_id() {
        return fh_id;
    }

    public void setFh_id(Long fh_id) {
        this.fh_id = fh_id;
    }

    public String getFh_name() {
        return fh_name;
    }

    public void setFh_name(String fh_name) {
        this.fh_name = fh_name;
    }

    public String getFh_location() {
        return fh_location;
    }

    public void setFh_location(String fh_location) {
        this.fh_location = fh_location;
    }

    public String getFh_link() {
        return fh_link;
    }

    public void setFh_link(String fh_link) {
        this.fh_link = fh_link;
    }

    public String getFh_telephone() {
        return fh_telephone;
    }

    public void setFh_telephone(String fh_telephone) {
        this.fh_telephone = fh_telephone;
    }

    public String getFh_intro() {
        return fh_intro;
    }

    public void setFh_intro(String fh_intro) {
        this.fh_intro = fh_intro;
    }

    public String getFh_type() {
        return fh_type;
    }

    public void setFh_type(String fh_type) {
        this.fh_type = fh_type;
    }
}
