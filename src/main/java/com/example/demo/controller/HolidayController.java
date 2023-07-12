package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.HolidayDto;
import com.example.demo.service.HolidayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class HolidayController {
    HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping("/holidays/new")
    public void save(@RequestBody HolidayDto holidayDto){
        holidayService.save(holidayDto);
    }

    @GetMapping("/holidays")
    public List<HolidayDto> listHolidays(){
        List<HolidayDto> holidays= holidayService.findAllHolidays();
        return holidays;
    }
}
