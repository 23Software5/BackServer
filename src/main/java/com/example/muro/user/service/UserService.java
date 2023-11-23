package com.example.muro.user.service;

import com.example.muro.user.dto.UserSignUpDto;
import com.example.muro.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public void signUp(UserSignUpDto UserSignUpDto) throws Exception{
        if (userRepository.findByNickname(UserSignUpDto.getNickname()).isPresent()) {
            throw new Exception("이미 존재하는 닉네임입니다.");
        }
    }*/

}
