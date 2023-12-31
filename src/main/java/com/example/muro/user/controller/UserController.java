package com.example.muro.user.controller;

import com.example.muro.user.domain.LoginRequest;
import com.example.muro.user.domain.Users;
//import com.example.muro.user.dto.UserDto;
import com.example.muro.user.dto.UserDto;
import com.example.muro.user.dto.UserResponse;
import com.example.muro.user.dto.UserSignUpDto;
import com.example.muro.user.repository.UserRepository;
import com.example.muro.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

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
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("회원 탈퇴 성공");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("사용자를 찾을 수 없습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("회원 탈퇴 중 오류가 발생했습니다.");
        }
    }

    //3)회원 조회(마이페이지)
    @GetMapping("/settings/{userId}")
    public Users getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    //4)로그인
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) {
        String userEmail = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        // 사용자 정보 확인
        Users user = userRepository.findByUserEmail(userEmail);
        if (user != null && user.getPassword().equals(password)) {
            // 로그인 성공 시 사용자의 ID를 응답으로 전달
            UserResponse userResponse = new UserResponse();
            userResponse.setUserId(user.getId()); // 또는 getId() 등으로 사용자 ID 설정

            // 토큰 발급 로직 등 추가할 부분

            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUserDetails(
            @PathVariable Long userId,
            @RequestBody UserDto userDto
    ) {
        try {
            Users userToUpdate = userService.getUserById(userId);

            if (userDto.getNickname() != null && !userDto.getNickname().isEmpty()) {
                userToUpdate.setNickname(userDto.getNickname());
            }

            if (userDto.getPhoneNumber() != null && !userDto.getPhoneNumber().isEmpty()) {
                userToUpdate.setPhoneNumber(userDto.getPhoneNumber());
            }

            userService.updateUser(userToUpdate);

            return ResponseEntity.ok("User information updated successfully.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating user information.");
        }
    }



    //public String signUp(@RequestBody UserSignUpDto userSignUpDto) throws Exception {
        //this.userService.signUp(userSignUpDto);
    //    return "회원가입 성공";
    //}


}
