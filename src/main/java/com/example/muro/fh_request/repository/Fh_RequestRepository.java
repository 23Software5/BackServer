package com.example.muro.fh_request.repository;
import com.example.muro.fh_request.domain.Fh_Request;
import com.example.muro.fh_request.dto.Fh_RequestDto;
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

    public void createFhRequest(Fh_RequestDto fhRequestDto) {
        Fh_Request fhRequest = new Fh_Request();

        // Fh_RequestDto로부터 필요한 정보 설정
        fhRequest.setFuneralhall(fhRequestDto.getFuneralhall());
        fhRequest.setUser(fhRequestDto.getUser());
        fhRequest.setPet_name(fhRequestDto.getPet_name());
        fhRequest.setPet_species(fhRequestDto.getPet_species());
        fhRequest.setPet_weight(fhRequestDto.getPet_weight());
        fhRequest.setFh_date(fhRequestDto.getFh_date());

        // 저장 - EntityManager 사용
        entityManager.persist(fhRequest);
    }

    public Optional<Fh_Request> findById(Long id) {
        Fh_Request request = entityManager.find(Fh_Request.class, id);
        return Optional.ofNullable(request);
    }
}