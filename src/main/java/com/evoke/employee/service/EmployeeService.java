package com.evoke.employee.service;

import com.evoke.employee.exceptions.DuplicateAccountException;
import com.evoke.employee.model.Employee;
import com.evoke.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        employee.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new DuplicateAccountException("Email is already registered: " + employee.getEmail());
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getById(id);
    }
}
