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
    public void delete(Long user) {
        if (user != null) {
            em.remove(user);
        } else {
            throw new IllegalArgumentException("해당 ID의 사용자를 찾을 수 없습니다.");
        }
    }


   public User findOne(Long id){
       return em.find(User.class, id);
   }


   public List<User> findAll(){
       return em.createQuery("select m from User m", User.class)
               .getResultList();

   }

   public List<User> findByNickname(String nickname){
       return em.createQuery("select m from User m where m.nickname = :nickname", User.class)
               .setParameter("nickname",nickname)
               .getResultList();
   }

    public User findByUserEmail(String email){
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();

        return users.isEmpty() ? null : users.get(0);
    }
        /*public User findByUserEmail(String email){
        return em.find(User.class, email);
    }*/



    //Optional<User> findByNickname(String nickname);

}
