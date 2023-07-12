package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String employeeId;
    private String email;
    private String designation;
    private Long mobile;
    private String address;
    private String department;
    private LocalDate DOJ;
    private LocalDate dob;
    private String status;
    private String employeeType;
    private String directManager;
    private String profileUrl;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Personal personal;

    @OneToMany(mappedBy = "employee")
    private List<Leaves> leaves;

    @OneToMany(mappedBy = "employee")
    private List<ApplyLeave> applyLeaves;

}
