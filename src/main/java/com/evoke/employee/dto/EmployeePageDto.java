package com.evoke.employee.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeePageDto {
    private List<EmployeeDto> employee;
    private int totalPages;
    private Long totalRecords;
}


