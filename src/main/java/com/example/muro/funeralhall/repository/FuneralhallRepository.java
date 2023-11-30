// FuneralHallRepository.java
package com.example.muro.funeralhall.repository;

import com.example.muro.funeralhall.domain.Funeralhall;
import com.example.muro.funeralhall.dto.FuneralhallDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuneralhallRepository extends JpaRepository<Funeralhall, Long> {

    @Query("SELECT new com.example.muro.funeralhall.dto.FuneralhallDto(f.fh_id, f.fh_name, f.fh_location, f.fh_link, f.fh_telephone, f.fh_intro, f.fh_type) FROM Funeralhall f")
    List<FuneralhallDto> getAllFuneralhalls();
}
