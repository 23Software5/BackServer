package com.example.muro.user.repository;

import com.example.muro.user.domain.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository{
   @PersistenceContext
   private EntityManager em;

   public void save(Users user){
       em.persist(user);
   }
    public void delete(Users user) {
        if (user != null) {
            em.remove(user);
        } else {
            throw new IllegalArgumentException("해당 사용자를 찾을 수 없습니다.");
        }
    }
    //user -> users로 변경


   public Users findOne(Long id){
       return em.find(Users.class, id);
   }


   public List<Users> findAll(){
       return em.createQuery("select m from users m", Users.class)
               .getResultList();

   }

   public List<Users> findByNickname(String nickname){
       return em.createQuery("select m from users m where m.nickname = :nickname", Users.class)
               .setParameter("nickname",nickname)
               .getResultList();
   }
    public Users findByUserEmail(String email) {
        try {
            TypedQuery<Users> query = em.createQuery("SELECT u FROM users u WHERE u.email = :email", Users.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    /*public User findByUserEmail(String email) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }*/


//    public User findByUserEmail(String email){
//        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
//                .setParameter("email", email)
//                .getResultList();
//
//        return users.isEmpty() ? null : users.get(0);
//    }
        /*public User findByUserEmail(String email){
        return em.find(User.class, email);
    }*/



    //Optional<User> findByNickname(String nickname);

}
//야호오