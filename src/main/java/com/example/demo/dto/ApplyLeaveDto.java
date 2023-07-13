package com.example.demo.dto;

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
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private String reason;
    private Long employeeId;
}
