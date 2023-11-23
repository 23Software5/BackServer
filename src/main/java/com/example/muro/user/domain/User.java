package com.example.muro.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "user_id")
    private Long userid;
    private String email;
    private String nickname;
    private String password;

    protected User() {
    }

    public User(final Long userID, final String email, final String nickname, final String password){
        this.userid = userID;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }




}
