package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Employee;

import com.example.demo.models.Leaves;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import static com.example.demo.mapper.EmployeeMapper.mapToEmployeeDto;
import static com.example.demo.mapper.EmployeeMapper.mapToEmployee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private LeaveRepository leaveRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,LeaveRepository leaveRepository) {

        this.employeeRepository = employeeRepository;
        this.leaveRepository = leaveRepository;
    }

    @Override
    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEmployee(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto findEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return mapToEmployeeDto(employee);
    }
    @Override
    public List<EmployeeDto> searchEmployees(String query) {
        List<Employee> employees= employeeRepository.searchEmployees(query);
        return employees.stream().map(employee -> mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }


    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEmployee(employeeDto);
        return employeeRepository.save(employee);
    }
    @Override
    public int getAvailabledays(String type) {
        if (type.equals("Medeicalleave")) {
            return Leaves.earnedLeave;
        }
        else if (type.equals("PaidLeave")) {
            return Leaves.sickLeave;
        }
        else
            return Leaves.paternityLeave;
    }

    @Override
    public Leaves getEmployeeById(int id) {
        return leaveRepository.findById(id);
    }


}