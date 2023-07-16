package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.ApplyLeave;
import com.example.demo.models.Employee;
import com.example.demo.repository.ApplyLeaveRepository;
import com.example.demo.service.ApplyLeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplyLeaveServiceImpl implements ApplyLeaveService {

    private final ApplyLeaveRepository applyLeaveRepository;

    @Override
    public void saveLeave(ApplyLeave applyLeave) {
        applyLeaveRepository.save(applyLeave);
    }

    @Override
    public List<ApplyLeave> getAll() {
        List<ApplyLeave> applyLeave =applyLeaveRepository .findAll();
        return applyLeave;
    }
    @Override
    public ApplyLeave getById(int id) {
        ApplyLeave applyLeave=applyLeaveRepository.getLeaveAppliedById(id);
        return applyLeave;
    }

    @Override
    public void delete(ApplyLeave applyLeave) {
        applyLeaveRepository.delete(applyLeave);
    }

    @Override
    public List<ApplyLeave> getByEmpId(EmployeeDto employee) {
        List<ApplyLeave> applyLeave=applyLeaveRepository.getLeaveAppliedByEmployee(employee);
        return applyLeave;
    }

    @Override
    public List<ApplyLeave> getApprovedByEmpId(EmployeeDto employee) {
        List<ApplyLeave> leaveApplied=applyLeaveRepository.getLeaveAppliedByEmployee(employee);
        leaveApplied=leaveApplied.stream().filter(e->e.getApproval()==1).collect(Collectors.toList());
        return leaveApplied;
    }

    @Override
    public void approve(ApplyLeave applyLeave) {
        applyLeave.setApproval(1);
        applyLeaveRepository.save(applyLeave);
    }
}
