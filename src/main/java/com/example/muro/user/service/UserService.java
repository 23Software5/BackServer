package com.example.muro.user.service;

import com.example.muro.user.domain.Users;
import com.example.muro.user.dto.UserSignUpDto;
import com.example.muro.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    //회원가입

    public Long join(Users user){
        this.validateDuplicateUser(user);
        this.userRepository.save(user);
        System.out.println(user);
        return user.getId();
    }

    public String insertUser(@RequestBody UserSignUpDto userdto){
        Users user = new Users();
        user.setEmail(userdto.getEmail());
        user.setNickname(userdto.getNickname());
        user.setPassword(userdto.getPassword());
        user.setPhoneNumber(userdto.getPhoneNumber());
        //validateDuplicateUser(user);
        //email검사 로직
        /*if (userRepository.findByUserEmail(user.getEmail()) != null) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }*/
        if (user.getEmail() != null && !user.getEmail().isEmpty() &&
                user.getNickname() != null && !user.getNickname().isEmpty() &&
                user.getPassword() != null && !user.getPassword().isEmpty()){
            userRepository.save(user);}
        System.out.println(user.getId());
        System.out.println(user.getNickname());
        System.out.println(user.getEmail());
        System.out.println(user.getPhoneNumber());

        return "회원가입 성공";

    }
    public void updateUser(Users users) {
        userRepository.save(users);
    }

    public void deleteUser(Long userId) {
        Users user = userRepository.findOne(userId);
        if (user != null) {
            userRepository.delete(user);
        } else {
            throw new NoSuchElementException("사용자를 찾을 수 없습니다.");
        }
    }

    public Users getUserById(Long userId) {
        return userRepository.findOne(userId);
    }

    /*public Users getUserById(Long userid){
        Optional<Users> user = Optional.ofNullable(userRepository.findOne(userid));
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new IllegalArgumentException("해당 ID의 사용자를 찾을 수 없습니다.");
        }
    }*/


    private void validateDuplicateUser(Users user) {
        //EXCEPTION
        List<Users> findUsers = userRepository.findByNickname(user.getNickname());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Users> findUsers(){
        return userRepository.findAll();
    }
    public Users findOne(Long userId){
        return userRepository.findOne(userId);
    }

    //회원 전체 조회

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public void signUp(UserSignUpDto UserSignUpDto) throws Exception{
        if (userRepository.findByNickname(UserSignUpDto.getNickname()).isPresent()) {
            throw new Exception("이미 존재하는 닉네임입니다.");
        }
    }*/

}
