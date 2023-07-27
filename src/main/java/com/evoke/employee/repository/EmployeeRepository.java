package com.evoke.employee.repository;

import com.evoke.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Boolean existsByEmail(String email);

    Optional<Employee> findByEmail(String email);



}
