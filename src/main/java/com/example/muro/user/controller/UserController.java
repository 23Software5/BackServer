package com.example.muro.user.controller;

import com.example.muro.user.dto.UserDto;
import com.example.muro.user.dto.UserSignUpDto;
import com.example.muro.user.repository.UserRepository;
import com.example.muro.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"*"}
)
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

   // @PostMapping({"/sign-up"})
    //public String signUp(@RequestBody UserSignUpDto userSignUpDto) throws Exception {
        //this.userService.signUp(userSignUpDto);
    //    return "회원가입 성공";
    //}

    @Autowired
    public UserController(final UserRepository userRepository, final UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
}
