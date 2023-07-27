package com.evoke.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDto {

    private Long id;
    private String name;
    private String reportingManager;
    private String role;
    private EmployeeDto employee;
    private Long employeeId;
}
