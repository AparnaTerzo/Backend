package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Employee;

import java.util.stream.Collectors;

public class EmployeeMapper {
    public static Employee mapToEmployee(EmployeeDto employee) {
        Employee employeeDto = Employee.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .employeeId(employee.getEmployeeId())
                .designation(employee.getDesignation())
                .mobile(employee.getMobile())
                .address(employee.getAddress())
                .department(employee.getDepartment())
                .DOJ(employee.getDOJ())
                .dob(employee.getDob())
                .profileUrl(employee.getProfileUrl())
                .status(employee.getStatus())
                .employeeType(employee.getEmployeeType())
                .directManager(employee.getDirectManager())


                .build();
        return  employeeDto;
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .dob(employee.getDob())
                .profileUrl(employee.getProfileUrl())
                .employeeId(employee.getEmployeeId())
                .designation(employee.getDesignation())
                .mobile(employee.getMobile())
                .address(employee.getAddress())
                .department(employee.getDepartment())
                .DOJ(employee.getDOJ())
                .status(employee.getStatus())
                .employeeType(employee.getEmployeeType())
                .bloodGroup(employee.getPersonal().getBloodGroup())
                .collegeName(employee.getPersonal().getCollegeName())
                .placeBorn(employee.getPersonal().getPlaceBorn())
                .gender(employee.getPersonal().getGender())
                .build();
        return employeeDto;
    }

}
