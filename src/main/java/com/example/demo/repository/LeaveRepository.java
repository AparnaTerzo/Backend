package com.example.demo.repository;

import com.example.demo.models.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leaves,Integer> {
    Leaves getLeavesByEmployeeId(int id);
}
