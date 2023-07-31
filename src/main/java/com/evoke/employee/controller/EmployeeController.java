package com.evoke.employee.controller;

import com.evoke.employee.dto.EmployeeDto;
import com.evoke.employee.mappers.EmployeeMapper;
import com.evoke.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper mapper;

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(employeeService.createEmployee(mapper.toEntity(employeeDto))));
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return ResponseEntity.ok(mapper.toDto(employeeService.getEmployee()));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok().body(mapper.toDto(employeeService.getEmployeeById(id).get()));
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
         employeeService.deleteEmployeeById(id);
    }
}
