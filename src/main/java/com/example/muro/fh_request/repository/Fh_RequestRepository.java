package com.example.muro.fh_request.repository;
import com.example.muro.fh_request.domain.Fh_Request;
import com.example.muro.user.domain.Users;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class Fh_RequestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void createFhRequest(Fh_Request fhRequest) {
        entityManager.persist(fhRequest);
    }

    public Optional<Fh_Request> findById(Long id) {
        Fh_Request request = entityManager.find(Fh_Request.class, id);
        return Optional.ofNullable(request);
    }
    public List<Fh_Request> findRequestsByUserId(Long userId) {
        return entityManager.createQuery("SELECT fr FROM Fh_Request fr WHERE fr.user.userid = :userId", Fh_Request.class)
                .setParameter("userId", userId)
                .getResultList();
    }
    public Users findUserById(Long userId) {
        return entityManager.find(Users.class, userId);
    }
}