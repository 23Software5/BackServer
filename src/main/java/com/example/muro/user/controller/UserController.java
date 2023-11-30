package com.example.muro.user.controller;

import com.example.muro.user.domain.LoginRequest;
import com.example.muro.user.domain.Users;
//import com.example.muro.user.dto.UserDto;
import com.example.muro.user.dto.UserSignUpDto;
import com.example.muro.user.repository.UserRepository;
import com.example.muro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    //@Autowired
    //private AuthenticationService authService;
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
    public String create(@RequestBody UserSignUpDto userDto){
        //System.out.println(user);
        //userService.insertUser(user);
        Users user = new Users();
        user.setEmail(userDto.getEmail());
        user.setNickname(userDto.getNickname());
        user.setPassword(userDto.getPassword());

        userService.join(user);

        return "redirect:/";
    }

    //2)회원 탈퇴
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "회원 탈퇴 성공";
    }

    //3)회원 조회(마이페이지)
    @GetMapping("/settings/{userId}")
    public Users getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    //4)로그인
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String userEmail = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        // 사용자 정보 확인
        Users user = userRepository.findByUserEmail(userEmail);
        if (user != null && user.getPassword().equals(password)) {
            //인증 토큰은 다시...
            //String token = authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());


            return "로그인 성공";
        } else {
            return "로그인 실패";
        }
    }



    //public String signUp(@RequestBody UserSignUpDto userSignUpDto) throws Exception {
        //this.userService.signUp(userSignUpDto);
    //    return "회원가입 성공";
    //}


}
