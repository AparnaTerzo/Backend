package com.example.demo.repository;

import com.example.demo.models.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    @Query("SELECT e from Employee e WHERE e.name LIKE CONCAT('%', :query, '%')")
    List<Employee> searchEmployees(String query);

    @Query("SELECT e FROM Employee e WHERE  MONTH(e.dob) = MONTH(:date) AND ((DAY(e.dob) - DAY(:date) < 7) OR (DAY(e.dob) = DAY(:date)))")
    List<Employee> findBirthdayBuddies(LocalDate date);

    @Query("SELECT e FROM Employee e WHERE MONTH(e.DOJ) = MONTH(:date) AND DAY(e.DOJ) = DAY(:date)")
    List<Employee> findAnniversary( LocalDate date);
    @Query("SELECT e FROM Employee e WHERE (YEAR(e.DOJ)=YEAR(:date)  AND DAY(e.DOJ)-DAY(:date) <=30)"  )
    List<Employee> findNewHires(@Param("date") LocalDate date);

    Employee getEmployeeByEmail(String email);


    List<Employee> findAll(Sort sort);

}





