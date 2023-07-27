package com.evoke.employee.service;

import com.evoke.employee.exceptions.ResourceNotFoundException;
import com.evoke.employee.model.Employee;
import com.evoke.employee.model.Hobbies;
import com.evoke.employee.repository.EmployeeRepository;
import com.evoke.employee.repository.HobbiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HobbiesService {

    @Autowired
    private HobbiesRepository hobbiesRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Hobbies save(Hobbies hobbies) {
        Optional<Employee> employee= employeeRepository.findById(hobbies.getEmployeeId());
        if(employee.isPresent()){
            hobbies.setEmployee(employee.get());
            return hobbiesRepository.save(hobbies);
        }else {
            throw new ResourceNotFoundException("Employee not found with employeeId: " + hobbies.getEmployeeId());
        }

    }
}
