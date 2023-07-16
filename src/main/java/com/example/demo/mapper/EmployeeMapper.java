package com.example.demo.mapper;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Employee;

public class EmployeeMapper {
    public static Employee mapToEmployee(EmployeeDto employeeDto) {

        Employee employee = Employee.builder()
                .id(employeeDto.getId())
                .name(employeeDto.getName())
                .email(employeeDto.getEmail())
                .designation(employeeDto.getDesignation())
                .mobile(employeeDto.getMobile())
                .address(employeeDto.getAddress())
                .department(employeeDto.getDepartment())
                .DOJ(employeeDto.getDOJ())
                .dob(employeeDto.getDob())
                .profileUrl(employeeDto.getProfileUrl())
                .status(employeeDto.getStatus())
                .employeeType(employeeDto.getEmployeeType())
                .directManager(employeeDto.getDirectManager())
                .build();

        return employee;
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {

        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .dob(employee.getDob())
                .profileUrl(employee.getProfileUrl())
                .designation(employee.getDesignation())
                .mobile(employee.getMobile())
                .address(employee.getAddress())
                .department(employee.getDepartment())
                .DOJ(employee.getDOJ())
                .status(employee.getStatus())
                .employeeType(employee.getEmployeeType())
                .directManager(employee.getDirectManager())

                .build();

        return employeeDto;
    }
}
