//package com.example.demo.service;
//
//import com.example.demo.dto.ApplyLeaveDto;
//import com.example.demo.mapper.ApplyLeaveMapper;
//import com.example.demo.models.ApplyLeave;
//import com.example.demo.repository.ApplyLeaveRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ApplyLeaveServiceImpl implements ApplyLeaveService {
//    private final ApplyLeaveRepository applyLeaveRepository;
//    private final ApplyLeaveMapper applyLeaveMapper;
//
//    @Autowired
//    public ApplyLeaveServiceImpl(ApplyLeaveRepository applyLeaveRepository, ApplyLeaveMapper applyLeaveMapper) {
//        this.applyLeaveRepository = applyLeaveRepository;
//        this.applyLeaveMapper = applyLeaveMapper;
//    }
//
//    @Override
//    public ApplyLeaveDto applyLeave(ApplyLeaveDto applyLeaveDto) {
//        ApplyLeave applyLeave = applyLeaveMapper.mapToApplyLeave(applyLeaveDto);
//        ApplyLeave savedApplyLeave = applyLeaveRepository.save(applyLeave);
//        return applyLeaveMapper.mapToApplyLeaveDto(savedApplyLeave);
//    }
//
//    @Override
//    public ApplyLeaveDto getApplyLeave(Long applyLeaveId) {
//        ApplyLeave applyLeave = applyLeaveRepository.findById(applyLeaveId)
//                .orElseThrow(() -> new RuntimeException("Apply Leave not found with ID: " + applyLeaveId));
//        return applyLeaveMapper.mapToApplyLeaveDto(applyLeave);
//    }
//
//    // Other methods
//}
