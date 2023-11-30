package com.example.muro.fh_request.controller;

import com.example.muro.fh_request.domain.FhRequestStatus;
import com.example.muro.fh_request.domain.Fh_Request;
import com.example.muro.fh_request.dto.Fh_RequestDto;
import com.example.muro.fh_request.repository.Fh_RequestRepository;
import com.example.muro.fh_request.service.Fh_RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requests")
public class Fh_RequestController {

    private final Fh_RequestService fhRequestService;
    private final Fh_RequestRepository fhRequestRepository;
    @Autowired
    public Fh_RequestController(Fh_RequestService fhRequestService, Fh_RequestRepository fhRequestRepository) {
        this.fhRequestRepository = fhRequestRepository;
        this.fhRequestService = fhRequestService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRequest(@RequestBody Fh_RequestDto fhRequestDto){
        try{
            fhRequestService.createFhRequest(fhRequestDto);
            return ResponseEntity.ok("장례 요청 성공");
        } catch(Exception e){
            e.printStackTrace(); // 에러 로그 출력
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("장례 요청을 생성하는 중에 오류 발생");
        }
    }

    //특정 request조회
    @GetMapping("/{id}")
    public ResponseEntity<Fh_Request> getRequestById(@PathVariable Long id) {
        Optional<Fh_Request> request = fhRequestService.getFhRequestById(id);

        if (request.isPresent()) {
            return new ResponseEntity<>(request.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{requestId}/update-status")
    public ResponseEntity<String> updateFhRequestStatus(
            @PathVariable Long requestId,
            @RequestParam FhRequestStatus newStatus
    ) {
        try {
            fhRequestService.updateFhRequestStatus(requestId, newStatus);
            return ResponseEntity.ok("Fh_Request status updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating Fh_Request status: " + e.getMessage());
        }
    }

    @GetMapping("/by-user/{userId}")
    public List<Fh_Request> getRequestsByUserId(@PathVariable Long userId) {
        return fhRequestRepository.findRequestsByUserId(userId);
    }



}
