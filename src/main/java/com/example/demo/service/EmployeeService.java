package com.example.demo.service;

import com.example.demo.dto.ApplyLeaveDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.ApplyLeave;
import com.example.demo.models.Employee;

import com.example.demo.models.Leaves;
import com.example.demo.models.User;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> findAllEmployees();

    List<EmployeeDto> searchEmployees(String query);
    void updateEmployee(EmployeeDto employee);

    EmployeeDto findEmployeeById(int  employeeId);

    void delete(int employeeId);


    List<EmployeeDto> findBirthdayBuddies();
    List<EmployeeDto> findAnniversary();
   List<EmployeeDto> findNewHires();

    void deleteUser(String email);
    void saveUser(User user);

    List<EmployeeDto> sortEmployees(String sortOrder);

    Employee getByEmail(String email);


}