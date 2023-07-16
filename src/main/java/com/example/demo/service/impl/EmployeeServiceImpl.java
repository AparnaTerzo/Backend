package com.example.demo.service.impl;

import com.example.demo.dto.ApplyLeaveDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.models.ApplyLeave;
import com.example.demo.models.Employee;

import com.example.demo.models.Leaves;
import com.example.demo.models.User;
import com.example.demo.repository.ApplyLeaveRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LeaveService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static com.example.demo.mapper.EmployeeMapper.mapToEmployeeDto;
import static com.example.demo.mapper.EmployeeMapper.mapToEmployee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    private final UserRepository userRepository;
    private final LeaveService leaveService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserRepository userRepository, LeaveService leaveService) {

        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.leaveService=leaveService;

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
    public EmployeeDto findEmployeeById(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> searchEmployees(String query) {
        List<Employee> employees = employeeRepository.searchEmployees(query);
        return employees.stream().map(employee -> mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public void delete(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }


    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEmployee(employeeDto);
        Leaves leaves=new Leaves();
        leaves.setEarnedLeave(6);
        leaves.setSickLeave(12);
        leaves.setPaternityLeave(12);
        employeeRepository.save(employee);
        leaves.setEmployee(employee);
        leaveService.saveLeaves(leaves);
        return employeeRepository.save(employee);
    }



    @Override
    public List<EmployeeDto> findBirthdayBuddies() {
        LocalDate today = LocalDate.now();
        List<Employee> employees = employeeRepository.findBirthdayBuddies(today);
        return employees.stream().map((employee) -> mapToEmployeeDto(employee)).collect(Collectors.toList());
    }


    @Override
    public List<EmployeeDto> findAnniversary() {
        LocalDate today = LocalDate.now();
        List<Employee> employees = employeeRepository.findAnniversary(today);
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }


    @Override
    public List<EmployeeDto> findNewHires() {
        LocalDate today = LocalDate.now();
        List<Employee> employees = employeeRepository.findNewHires(today);
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }



    @Override
    public void deleteUser(String email) {
        User user=userRepository.findByEmail(email).orElseThrow();
        userRepository.delete(user);
    }

    @Override
    public void saveUser(User user) {

    }
    @Override
    public List<EmployeeDto> sortEmployees(String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by("name").ascending() :
                Sort.by("name").descending();

        List<Employee> employees = employeeRepository.findAll(sort);

        return employees.stream()
                .map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }
    @Override
    public Employee getByEmail(String email) {
        Employee employee=employeeRepository.getEmployeeByEmail(email);
        return employee;
    }


}
