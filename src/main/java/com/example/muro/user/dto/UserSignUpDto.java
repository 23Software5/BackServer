package com.example.muro.user.dto;

public class UserSignUpDto {
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;

    public UserSignUpDto() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNickname() {
        return this.nickname;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
}
