package com.example.muro.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserDto {

    private Long user_id;

    private String email;

    private String nickname;

    private String password;


    /*@NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phoneNumber;*/

    @Builder
    public UserDto(Long user_id, String password, String email, String phoneNumber) {
        this.user_id = user_id;
        this.password = password;
        this.email = email;
        //this.phoneNumber = phoneNumber;
    }



}
