package com.example.muro.user.domain;


public class LoginRequest {
    private String useremail;
    private String password;

    public String getEmail() {
        return useremail;
    }

    public void setUsername(String useremail) {
        this.useremail = useremail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
