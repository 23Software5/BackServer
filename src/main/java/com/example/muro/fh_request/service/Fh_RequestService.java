package com.example.muro.fh_request.service;

import com.example.muro.fh_request.domain.Fh_Request;
import com.example.muro.fh_request.dto.Fh_RequestDto;
import com.example.muro.fh_request.repository.Fh_RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class Fh_RequestService {
    @Autowired
    private final Fh_RequestRepository fhRequestRepository;

    public Fh_RequestService(Fh_RequestRepository fhRequestRepository) {
        this.fhRequestRepository = fhRequestRepository;
    }
    public void createFhRequest(Fh_RequestDto fhRequestDto) {
        Fh_Request fhRequest = new Fh_Request();

        // Fh_RequestDto로부터 필요한 정보 설정
        fhRequest.setFuneralhall(fhRequestDto.getFuneralhall());
        fhRequest.setUser(fhRequestDto.getUser());
        fhRequest.setPet_name(fhRequestDto.getPet_name());
        fhRequest.setPet_species(fhRequestDto.getPet_species());
        fhRequest.setPet_weight(fhRequestDto.getPet_weight());
        fhRequest.setFh_date(fhRequestDto.getFh_date());

        // 저장 로직 - Repository 사용
        fhRequestRepository.createFhRequest(fhRequestDto);
    }

    public Optional<Fh_Request> getFhRequestById(Long id) {
        return fhRequestRepository.findById(id);
    }


}
