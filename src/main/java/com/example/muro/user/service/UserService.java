package com.example.muro.user.service;

import com.example.muro.user.domain.User;
import com.example.muro.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    //회원가입

    public Long join(User user){
        this.validateDuplicateUser(user);
        this.userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        //EXCEPTION
        List<User> findUsers = userRepository.findByNickname(user.getNickname());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }
    public User findOne(Long userId){
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
