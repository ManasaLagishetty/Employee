package com.evoke.employee.service;

import com.evoke.employee.exceptions.DuplicateAccountException;
import com.evoke.employee.model.Employee;
import com.evoke.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

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

    public Page<Employee> getEmployee(int pageNumber,int pageSize,String sort1) {
        Sort sort=Sort.by(Sort.Direction.ASC,sort1);
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        return employeePage;
    }

    @Cacheable(value="employee" ,key="#id")
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @CacheEvict(value = "employee",key="#id")
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
