package com.example.demo.service;


import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.ApplyLeave;
import com.example.demo.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  interface ApplyLeaveService {

    void saveLeave(ApplyLeave applyLeave);
    List<ApplyLeave> getAll();

    ApplyLeave getById(int id);

    void delete(ApplyLeave leaveApplied);

    List<ApplyLeave> getByEmpId(EmployeeDto employee);

    List<ApplyLeave> getApprovedByEmpId(EmployeeDto employee);

    void approve(ApplyLeave leaveApplied);

}
