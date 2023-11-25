// FuneralhallDto.java
package com.example.muro.funeralhall.dto;

import lombok.Getter;

@Getter
public class FuneralhallDto {
<<<<<<< HEAD
    //funeralhallDTO
=======
>>>>>>> 9989690db36037d94e7d2667d62d1a5c0abb16fa

    private Long fh_id;
    private String fh_name;
    private String fh_location;
    private String fh_link;
    private String fh_telephone;
    private String fh_intro;

    // 생성자 추가
    public FuneralhallDto(Long fh_id, String fh_name, String fh_location, String fh_link, String fh_telephone, String fh_intro) {
        this.fh_id = fh_id;
        this.fh_name = fh_name;
        this.fh_location = fh_location;
        this.fh_link = fh_link;
        this.fh_telephone = fh_telephone;
        this.fh_intro = fh_intro;
    }
}
