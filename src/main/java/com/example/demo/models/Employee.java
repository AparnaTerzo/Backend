package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="employee")
public
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String designation;
    @Column(unique = true)
    private Long mobile;
    private String address;
    private String department;
    private LocalDate DOJ;
    private LocalDate dob;
    private String status;
    private String employeeType;
    private String profileUrl;
    private int directManager;

    @OneToMany(mappedBy = "employee")
    private List<Leaves> leaves;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ApplyLeave> appliedLeaves;

}
