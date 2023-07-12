package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.HolidayDto;
import com.example.demo.models.Employee;
import com.example.demo.models.Holiday;

public class HolidayMapper {
    public static Holiday mapToHoliday(HolidayDto holiday) {
        Holiday holidayDto = Holiday.builder()
                .id(holiday.getId())
                .name(holiday.getName())
                .date(holiday.getDate())
                .build();
        return  holidayDto;
    }
    public static HolidayDto mapToHolidayDto(Holiday holiday) {
        HolidayDto holidayDto = HolidayDto.builder()
                .id(holiday.getId())
                .name(holiday.getName())
                .date(holiday.getDate())
                .build();
        return  holidayDto;
    }



}
