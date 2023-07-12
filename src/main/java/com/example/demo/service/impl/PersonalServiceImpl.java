//package com.example.demo.service.impl;
//
//import com.example.demo.dto.EmployeeDto;
//import com.example.demo.dto.PersonalDto;
//import com.example.demo.models.Employee;
//import com.example.demo.models.Personal;
//import com.example.demo.repository.EmployeeRepository;
//import com.example.demo.repository.PersonalRepository;
//import com.example.demo.service.PersonalService;
//
//import static com.example.demo.mapper.EmployeeMapper.mapToEmployee;
//import static com.example.demo.mapper.PersonalMapper.mapToPersonal;
//
//public class PersonalServiceImpl implements PersonalService {
//    private PersonalRepository personalRepository;
//    public PersonalServiceImpl(PersonalRepository personalRepository) {
//
//        this.personalRepository = personalRepository;
//    }
//
//
//
//    @Override
//    public Personal savePersonal(PersonalDto personalDto) {
//        Personal personal = mapToPersonal(personalDto);
//        return personalRepository.save(personal);
//    }
//
//}
