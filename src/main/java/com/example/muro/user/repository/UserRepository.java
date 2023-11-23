package com.example.muro.user.repository;

import com.example.muro.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository{
   @PersistenceContext
   private EntityManager em;

   public void save(User user){
       em.persist(user);
   }

   public User findOne(Long id){
       return em.find(User.class, id);
   }

   public List<User> findAll(){
       return em.createQuery("select m from User m", User.class)
               .getResultList();

   }

   public List<User> findByNickname(String nickname){
       return em.createQuery("select m from Member m where m.nickname = :nickname", User.class)
               .setParameter("nickname",nickname)
               .getResultList();
   }

    //Optional<User> findByNickname(String nickname);

}
