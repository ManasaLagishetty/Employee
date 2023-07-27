package com.evoke.employee.service;

import com.evoke.employee.exceptions.ResourceNotFoundException;
import com.evoke.employee.model.Employee;
import com.evoke.employee.model.PersonalInformation;
import com.evoke.employee.repository.EmployeeRepository;
import com.evoke.employee.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalInformationService {
    @Autowired
    private PersonalInformationRepository personalInfoRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    public PersonalInformation savePersonalInfo(PersonalInformation personalInfo) {
        Optional<Employee> employee= employeeRepository.findById(personalInfo.getEmployeeId());
        if(employee.isPresent()) {
            personalInfo.setEmployee(employee.get());
           return personalInfoRepository.save(personalInfo);
        }else{
            throw new ResourceNotFoundException("Employee not found "+personalInfo.getEmployeeId());
        }

    }

    public List<PersonalInformation> getInfo() {
       return personalInfoRepository.findAll();
    }
}
