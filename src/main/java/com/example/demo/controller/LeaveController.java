package com.example.demo.controller;

import com.example.demo.models.ApplyLeave;
import com.example.demo.models.Employee;
import com.example.demo.service.LeaveService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.temporal.ChronoUnit;

public class LeaveController {
    LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }


}
