package com.example.muro.user.controller;

import com.example.muro.user.domain.User;
import com.example.muro.user.dto.UserDto;
import com.example.muro.user.dto.UserSignUpDto;
import com.example.muro.user.repository.UserRepository;
import com.example.muro.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(
        origins = {"*"}
)
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    @Autowired
    public UserController(final UserRepository userRepository, final UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    //회원가입 버튼을 누를시 화면만 보여주는 void 메소드
    @GetMapping("/newuser")
    public void join(){
    }

    //1)회원가입
    @PostMapping("/newuser")//@Valid를 사용하면 커맨드 객체(사용자가 입력한 값을 담은 클래스)에 대한 검증을 스프링이 수행한다.
    public String create(@Valid UserSignUpDto user){

        userService.insertUser(user);

        return "redirect:/";
    }

    //2)회원 탈퇴
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "회원 탈퇴 성공";
    }


    //public String signUp(@RequestBody UserSignUpDto userSignUpDto) throws Exception {
        //this.userService.signUp(userSignUpDto);
    //    return "회원가입 성공";
    //}


}
