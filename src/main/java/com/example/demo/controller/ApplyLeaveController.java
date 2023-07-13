//package com.example.demo.controller;
//
//import com.example.demo.dto.ApplyLeaveDto;
//import com.example.demo.service.ApplyLeaveService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/apply-leaves")
//public class ApplyLeaveController {
//    private final ApplyLeaveService applyLeaveService;
//
//    @Autowired
//    public ApplyLeaveController(ApplyLeaveService applyLeaveService) {
//        this.applyLeaveService = applyLeaveService;
//    }
//
//    @PostMapping
//    public ResponseEntity<ApplyLeaveDto> applyLeave(@Valid @RequestBody ApplyLeaveDto applyLeaveDto) {
//        ApplyLeaveDto createdApplyLeave = applyLeaveService.applyLeave(applyLeaveDto);
//        return ResponseEntity.ok(createdApplyLeave);
//    }
//
//    @GetMapping("/{applyLeaveId}")
//    public ResponseEntity<ApplyLeaveDto> getApplyLeave(@PathVariable("applyLeaveId") Long applyLeaveId) {
//        ApplyLeaveDto applyLeaveDto = applyLeaveService.getApplyLeave(applyLeaveId);
//        return ResponseEntity.ok(applyLeaveDto);
//    }
//
//    // Other API endpoints for update, delete, get all apply leaves, etc.
//}
