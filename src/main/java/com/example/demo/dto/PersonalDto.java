package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalDto {
    private Long id;
    private String bloodGroup;
    private String collegeName;
    private String placeBorn;
    private String gender;

}
