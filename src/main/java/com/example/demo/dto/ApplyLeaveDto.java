package com.example.demo.dto;

import com.example.demo.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplyLeaveDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private String note;
    private Employee employee;
}
