// FuneralhallController.java
package com.example.muro.funeralhall.controller;

import com.example.muro.funeralhall.domain.Funeralhall;
import com.example.muro.funeralhall.dto.FuneralhallDto;
import com.example.muro.funeralhall.service.FuneralhallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funeralhalls")
public class FuneralhallController {

    @Autowired
    private FuneralhallService funeralhallService;

    @GetMapping
    public List<FuneralhallDto> getAllFuneralhalls() {
        return funeralhallService.getAllFuneralhalls();
    }

    @GetMapping("/{id}")
    public FuneralhallDto getFuneralhallById(@PathVariable Long id) {
        Funeralhall funeralhall = funeralhallService.getFuneralhallById(id);
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

    // 추가적인 엔드포인트 및 기능을 필요에 따라 추가할 수 있습니다.
}
