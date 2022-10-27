package com.example.mock_1.repository;

import com.example.mock_1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.employeeEmail = ?1")
    Optional<Employee> findEmployeeByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.employeePhone = ?1")
    Optional<Employee> findEmployeeByPhoneNumber(String phoneNumber);

}
