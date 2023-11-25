package com.example.muro.user.repository;

import com.example.muro.user.domain.User;
import com.example.muro.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {
    @Autowired UserRepository userRepository;
    @Autowired UserService userService;
    @Autowired EntityManager em;

    @Test
    public void SignUpTest() throws Exception{
        //given
        User user = new User();
        user.setNickname("SOWON");

        //when
        Long savedId = userService.join(user);

        //then
        em.flush();
        assertEquals(user, userRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)

    public void SameUserTest() throws Exception{
        //given
        User user1 = new User();
        user1.setNickname("SOWON");
        User user2 = new User();
        user2.setNickname("SOWON");

        //when
        userService.join(user1);
        try{

        }catch(IllegalStateException e){
            return;}
        userService.join(user2);

        //then
        fail("예외");
    }





}