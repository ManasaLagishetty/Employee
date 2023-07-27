package com.evoke.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HobbiesDto {
    private Long id;
    private String hobby;
    private EmployeeDto employee;
    private Long employeeId;
}
