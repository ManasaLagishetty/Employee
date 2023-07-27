package com.evoke.employee.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrganizationHistoryDto {

    private Long id;

    private String organizationName;

    private List<EmployeeDto> employees;
}
