package com.evoke.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private Long id;
    private String city;
    private String country;
    private String zipcode;
    private EmployeeDto employee;
    private Long employeeId;


}
