package com.example.demo.repository;

import com.example.demo.models.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday,Integer> {

}
