package com.example.muro.user.domain;

import javax.persistence.*;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userid;
    private String email;
    private String nickname;
    private String password;

    //private String phoneNumber;

    public Users(){

    }

    /*@Builder
    public User(Long userid,String email,  String nickname, String password) {
        this.userid = userid;
        this.nickname = nickname;
        this.email = email;
        this.password = password;

    }*/

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
    public void setUserId(final Long userid) {
        this.userid = userid;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }




    /*public User(final Long userID, final String email, final String nickname, final String password){
        this.id = userID;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }*/




}
