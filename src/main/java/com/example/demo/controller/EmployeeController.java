package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.ApplyLeave;
import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> listEmployees(){
        List<EmployeeDto> employees = employeeService.findAllEmployees();

        return employees;
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeDto employeeDetail(@PathVariable("employeeId") long employeeId) {
        EmployeeDto employee = employeeService.findEmployeeById(employeeId);
        return employee;
    }

    @PostMapping("/employees/new")
    public void saveEmployee(@RequestBody  EmployeeDto employeeDto){
        employeeService.saveEmployee(employeeDto);

    }

    @PutMapping("/employees/{employeeId}")
    public EmployeeDto updateEmployee( @PathVariable("employeeId") Long id ,@RequestBody EmployeeDto employee){
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return employee;
    }


    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") long id){
        EmployeeDto employee = employeeService.findEmployeeById(id);
        if(employee == null){
            throw new RuntimeException("Employee id not found : "+id);
        }
        employeeService.delete(id);
        return "deleted emp id - " +id;
    }
    @GetMapping("/employees/search/{query}")
    public List<EmployeeDto> searchEmployees(@PathVariable String query){
        List<EmployeeDto> employees = employeeService.searchEmployees(query);
        return employees;
    }
    @PutMapping("/employee/{id}/leave")
    public String Leave(@PathVariable("id") int id, @RequestBody ApplyLeave applyLeave){
        Employee Leave1= employeeService.getEmployeeById(id).getEmployee();
        String type=applyLeave.getType();
        int available=employeeService.getAvailabledays(type);
        if((int)(ChronoUnit.DAYS.between(applyLeave.getEndDate(),applyLeave.getStartDate()))>available){
            return "Leave Request is sent to Manager";
        }
        else
            return "No available Days";
    }


}