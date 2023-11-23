package com.example.muro.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userid;
    private String email;
    private String nickname;
    private String password;

    public User(){

    }
    public Long getId() {
        return this.userid;
    }

    public String getEmail() {
        return this.email;
    }
    public String getNickname() {
        return this.nickname;
    }
    public String getPassword() {
        return this.password;
    }



    /*public User(final Long userID, final String email, final String nickname, final String password){
        this.id = userID;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }*/




}
