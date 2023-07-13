package com.example.demo.mapper;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Employee;
import com.example.demo.models.Personal;

public class EmployeeMapper {
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        Personal personal = Personal.builder()
                .bloodGroup(employeeDto.getBloodGroup())
                .collegeName(employeeDto.getCollegeName())
                .placeBorn(employeeDto.getPlaceBorn())
                .gender(employeeDto.getGender())
                .build();

        Employee employee = Employee.builder()
                .id(employeeDto.getId())
                .name(employeeDto.getName())
                .email(employeeDto.getEmail())
                .employeeId(employeeDto.getEmployeeId())
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
                .personal(personal)
                .build();

        personal.setEmployee(employee);

        return employee;
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
