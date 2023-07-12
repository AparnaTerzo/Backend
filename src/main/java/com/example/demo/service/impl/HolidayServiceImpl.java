package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.HolidayDto;
import com.example.demo.models.Employee;
import com.example.demo.models.Holiday;
import com.example.demo.repository.HolidayRepository;
import com.example.demo.service.HolidayService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.mapper.EmployeeMapper.mapToEmployee;
import static com.example.demo.mapper.EmployeeMapper.mapToEmployeeDto;
import static com.example.demo.mapper.HolidayMapper.mapToHolidayDto;

@Service
public class HolidayServiceImpl implements HolidayService {

    HolidayRepository holidayRepository;

    @Autowired
    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository= holidayRepository;
    }

    @Override
    public List<HolidayDto> findAllHolidays() {
        List<Holiday> holidays= holidayRepository.findAll();
        return holidays.stream().map((holiday) -> mapToHolidayDto(holiday)).collect(Collectors.toList());
    }

    @Override
    public void save(HolidayDto holidayDto) {
        Holiday holiday = new Holiday();
        holidayRepository.save(holiday);
    }

}
