package com.example.demo.service.impl;

import com.example.demo.models.ApplyLeave;
import com.example.demo.models.Employee;
import com.example.demo.models.Leaves;
import com.example.demo.repository.LeaveRepository;
import com.example.demo.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl implements LeaveService {
    private final LeaveRepository leaveRepository;

    public LeaveServiceImpl(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }


    @Override
    public void reduceLeave(ApplyLeave applyLeave) {
        Employee employee=applyLeave.getEmployee();
        Leaves leaves=leaveRepository.getLeavesByEmployeeId(employee.getId());
        String type=applyLeave.getType();
        if(type.equals("Sick"))
            leaves.setSickLeave(leaves.getSickLeave()-1);
        else if(type.equals("Earned"))
            leaves.setEarnedLeave(leaves.getEarnedLeave()-1);
        else
            leaves.setPaternityLeave(leaves.getPaternityLeave()-1);
        leaveRepository.save(leaves);
    }

    @Override
    public void saveLeaves(Leaves leaves) {
        leaveRepository.save(leaves);
    }

    @Override
    public Leaves getByEmpId(int id) {
        Leaves leaves=leaveRepository.getLeavesByEmployeeId(id);
        return leaves;
    }
}
