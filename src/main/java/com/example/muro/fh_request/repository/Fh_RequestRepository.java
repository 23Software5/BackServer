package com.example.muro.fh_request.repository;
import com.example.muro.fh_request.domain.Fh_Request;
import com.example.muro.user.domain.Users;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
    public Users findUserById(Long userId) {
        return entityManager.find(Users.class, userId);
    }
}