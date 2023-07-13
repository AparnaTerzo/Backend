package com.example.demo.service;

import com.example.demo.dto.ApplyLeaveDto;

public interface ApplyLeaveService {
    ApplyLeaveDto applyLeave(ApplyLeaveDto applyLeaveDto);
    ApplyLeaveDto getApplyLeave(Long applyLeaveId);
    // Other methods
}
