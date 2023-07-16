package com.example.demo.repository;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.ApplyLeave;
import com.example.demo.models.Employee;
import com.example.demo.models.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ApplyLeaveRepository extends JpaRepository<ApplyLeave,Integer> {
    ApplyLeave getLeaveAppliedById(int id);
    List<ApplyLeave> getLeaveAppliedByEmployee(EmployeeDto employee);

}
