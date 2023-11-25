package com.example.muro.user.dto;

import com.example.muro.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/*
@Getter
public class UserDto {

    private Long user_id;
    @NotBlank(message = "이메일을 입력해주세요")
    private String email;
    @NotBlank(message = "이름을 입력해주세요")
    private String nickname;
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 8, max = 20, message = "8자~20자")
    private String password;

    /*@NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phoneNumber;*/

    /*@Builder
    public UserDto(Long user_id, String password, String email, String phoneNumber) {
        this.user_id = user_id;
        this.password = password;
        this.email = email;
        //this.phoneNumber = phoneNumber;
    }



}*/
