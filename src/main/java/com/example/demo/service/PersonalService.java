package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.PersonalDto;
import com.example.demo.models.Employee;
import com.example.demo.models.Personal;

public interface PersonalService {
    Personal savePersonal(PersonalDto personalDto);
}
