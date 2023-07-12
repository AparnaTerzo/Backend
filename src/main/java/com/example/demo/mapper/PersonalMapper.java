package com.example.demo.mapper;

import com.example.demo.dto.PersonalDto;
import com.example.demo.models.Personal;

public class PersonalMapper {
    public static Personal mapToPersonal(PersonalDto personal) {
        Personal personalDto = Personal.builder()
                .id(personal.getId())
                .gender(personal.getGender())
                .placeBorn(personal.getPlaceBorn())
                .collegeName(personal.getPlaceBorn())
                .bloodGroup(personal.getBloodGroup())

                .build();
        return  personalDto;
    }

    public static Personal mapToPersonalDto(Personal personal) {
        Personal personalDto = Personal.builder()
                .id(personal.getId())
                .gender(personal.getGender())
                .placeBorn(personal.getPlaceBorn())
                .collegeName(personal.getPlaceBorn())
                .bloodGroup(personal.getBloodGroup())

                .build();
        return personalDto;
    }

}
