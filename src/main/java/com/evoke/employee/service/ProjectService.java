package com.evoke.employee.service;

import com.evoke.employee.exceptions.ResourceNotFoundException;
import com.evoke.employee.model.Employee;
import com.evoke.employee.model.Project;
import com.evoke.employee.repository.EmployeeRepository;
import com.evoke.employee.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Project saveProject(Project project) {
        Optional<Employee> employee = employeeRepository.findById(project.getEmployeeId());
        if (employee.isPresent()) {
            project.setEmployee(employee.get());
            return projectRepository.save(project);
        } else {
            throw new ResourceNotFoundException("Employee not found" + project.getEmployeeId());
        }

    }
}
