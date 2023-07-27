package com.evoke.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalInformationDto {
    private Long id;
    private String gender;
    private String maritalStatus;
    private String nationality;
    private String dateOfBirth;
    private EmployeeDto employee;
    private Long employeeId;

}
