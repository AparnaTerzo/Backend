package com.example.demo.controller;

import com.example.demo.dto.ApplyLeaveDto;
import com.example.demo.dto.EmployeeDto;

import com.example.demo.dto.UserRoleDto;
import com.example.demo.models.ApplyLeave;
import com.example.demo.models.Employee;
import com.example.demo.models.Leaves;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApplyLeaveService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LeaveService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.example.demo.mapper.EmployeeMapper.mapToEmployeeDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final ApplyLeaveService applyLeaveService;
    EmployeeService employeeService;
    private final UserRepository userRepository;
    private final LeaveService leaveService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,UserRepository userRepository,ApplyLeaveService applyLeaveService,LeaveService leaveService) {
        this.userRepository=userRepository;
        this.employeeService = employeeService;
        this.applyLeaveService=applyLeaveService;
        this.leaveService =leaveService;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> listEmployees(){
        List<EmployeeDto> employees = employeeService.findAllEmployees();
        return employees;
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeDto employeeDetail(@PathVariable("employeeId") int employeeId) {
        EmployeeDto employee = employeeService.findEmployeeById(employeeId);
        return employee;
    }

    @PostMapping("/employees/new")
    public void saveEmployee(@RequestBody  EmployeeDto employeeDto){
        employeeService.saveEmployee(employeeDto);

    }

    @PutMapping("/employees/{employeeId}")
    public EmployeeDto updateEmployee( @PathVariable("employeeId") int id ,@RequestBody EmployeeDto employee){
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return employee;
    }


    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int id){
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
    @GetMapping("/birthday")
    public List<EmployeeDto> getBirthdayBuddies() {
        return employeeService.findBirthdayBuddies();
    }
    @GetMapping("/anniversary")
    public List<EmployeeDto> getAnniversary() {
        return employeeService.findAnniversary();
    }
    @GetMapping("/hires")
    public List<EmployeeDto> getNewHires() {
        return employeeService.findNewHires();
    }


    @GetMapping("/delete/{email}")
    public void deleteUser(@PathVariable String email){
        employeeService.deleteUser(email);
    }

    @GetMapping("/role/{email}")
    public UserRoleDto getRole(@PathVariable String email){
        User user=userRepository.findByEmail(email).orElseThrow();
        UserRoleDto userRole=new UserRoleDto();
        userRole.setRole(user.getRole().name());
        return userRole;
    }

    @GetMapping("/sort/{sortOrder}")
    public ResponseEntity<List<EmployeeDto>> sortEmployees(@PathVariable String sortOrder) {
        List<EmployeeDto> employees = employeeService.sortEmployees(sortOrder);
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/employee/{email}/get")
    public EmployeeDto getEmployeeDetails(@PathVariable String email){
        Employee employee=employeeService.getByEmail(email);
        EmployeeDto employeeDto=mapToEmployeeDto(employee);
        return employeeDto;
    }



    @PostMapping("/apply")
    public void addLeaveApplication(@RequestBody ApplyLeave leaveApplied){
        applyLeaveService.saveLeave(leaveApplied);
    }

    @GetMapping("/admin/viewLeave")
    public List<ApplyLeave> viewAppliedLeaves(){
        List<ApplyLeave> leavesApplied=applyLeaveService.getAll();
        return leavesApplied;
    }

    @PostMapping("/admin/approve-leave/{leaveId}")
    public void approveLeave(@PathVariable int leaveId){
        ApplyLeave applyLeave=applyLeaveService.getById(leaveId);
        leaveService.reduceLeave(applyLeave);
        applyLeaveService.approve(applyLeave);
    }

    @GetMapping("/approved-leave/{employeeId}")
    public List<ApplyLeave> getApprovedLeave(@PathVariable int employeeId){
        EmployeeDto employee=employeeService.findEmployeeById(employeeId);
        List<ApplyLeave> leavesApproved=applyLeaveService.getApprovedByEmpId(employee);
        return leavesApproved;
    }
}
