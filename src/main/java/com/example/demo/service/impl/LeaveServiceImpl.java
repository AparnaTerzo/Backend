package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;

import com.example.demo.models.Employee;
import com.example.demo.models.Leaves;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LeaveService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.demo.mapper.EmployeeMapper.mapToEmployee;

public class LeaveServiceImpl implements LeaveService {
   private LeaveRepository leaveRepository;

    private EmployeeService employeeService;

    public LeaveServiceImpl(LeaveRepository leaveRepository, EmployeeService employeeService) {
        this.leaveRepository = leaveRepository;
        this.employeeService = employeeService;
    }



}
