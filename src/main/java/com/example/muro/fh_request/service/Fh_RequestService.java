package com.example.muro.fh_request.service;

import com.example.muro.fh_request.domain.FhRequestStatus;
import com.example.muro.fh_request.domain.Fh_Request;
import com.example.muro.fh_request.dto.Fh_RequestDto;
import com.example.muro.fh_request.repository.Fh_RequestRepository;
import com.example.muro.user.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class Fh_RequestService {

    private final Fh_RequestRepository fhRequestRepository;

    @Autowired
    public Fh_RequestService(Fh_RequestRepository fhRequestRepository) {
        this.fhRequestRepository = fhRequestRepository;
    }

    public void createFhRequest(Fh_RequestDto fhRequestDto) {
        // Fh_Request 인스턴스 생성
        Fh_Request fhRequest = new Fh_Request();

        // Fh_RequestDto로부터 필요한 정보 설정
        fhRequest.setFuneralhall(fhRequestDto.getFuneralhall());

        // User 엔티티 가져오기
        Users existingUser = fhRequestRepository.findUserById(fhRequestDto.getUserId());

        // 가져온 User 엔티티를 Fh_Request 엔티티에 할당
        fhRequest.setUser(existingUser);

        // Fh_RequestDto에서 필요한 정보 설정
        fhRequest.setPet_name(fhRequestDto.getPet_name());
        fhRequest.setPet_species(fhRequestDto.getPet_species());
        fhRequest.setPet_weight(fhRequestDto.getPet_weight());
        fhRequest.setFh_date(fhRequestDto.getFh_date());

        // 저장 로직 - Repository 사용
        fhRequestRepository.createFhRequest(fhRequest);
    }

    public void updateFhRequestStatus(Long requestId, FhRequestStatus newStatus) {
        Optional<Fh_Request> optionalFhRequest = fhRequestRepository.findById(requestId);

        optionalFhRequest.ifPresent(fhRequest -> {
            fhRequest.setStatus(newStatus);
            fhRequestRepository.createFhRequest(fhRequest); // 혹은 update 메서드 활용
        });
    }

    public Optional<Fh_Request> getFhRequestById(Long id) {
        return fhRequestRepository.findById(id);
    }
}
