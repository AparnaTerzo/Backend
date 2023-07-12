package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.HolidayDto;
import com.example.demo.models.Holiday;

import java.util.List;

public interface HolidayService {
    void save(HolidayDto holidayDto);

    List<HolidayDto> findAllHolidays();
}
