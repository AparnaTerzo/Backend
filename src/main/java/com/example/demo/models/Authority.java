package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Authority {
    @Id
    private String email;
    private String role;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private Users users;
}
