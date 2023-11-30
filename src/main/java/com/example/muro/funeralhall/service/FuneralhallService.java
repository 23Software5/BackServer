// FuneralhallService.java
package com.example.muro.funeralhall.service;

import com.example.muro.funeralhall.domain.Funeralhall;
import com.example.muro.funeralhall.dto.FuneralhallDto;
import com.example.muro.funeralhall.repository.FuneralhallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuneralhallService {

    @Autowired
    private FuneralhallRepository funeralHallRepository;

    public List<Funeralhall> getAllFuneralHalls() {
        return funeralHallRepository.findAll();
    }

    public Funeralhall getFuneralhallById(Long id) {
        return funeralHallRepository.findById(id).orElse(null);
    }

    public List<FuneralhallDto> getAllFuneralhalls() {
        List<Funeralhall> funeralhalls = funeralHallRepository.findAll();
        return funeralhalls.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private FuneralhallDto convertToDto(Funeralhall funeralhall) {
        return new FuneralhallDto(
                funeralhall.getFh_id(),
                funeralhall.getFh_name(),
                funeralhall.getFh_location(),
                funeralhall.getFh_link(),
                funeralhall.getFh_telephone(),
                funeralhall.getFh_intro(),
                funeralhall.getFh_type()
        );
    }
}