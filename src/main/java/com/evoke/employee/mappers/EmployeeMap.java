package com.evoke.employee.mappers;

import com.evoke.employee.dto.EmployeeDto;
import com.evoke.employee.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class EmployeeMap {
    public EmployeeDto toDto(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setPassword(employee.getPassword());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setCreatedAt(employee.getCreatedAt());
        return employeeDto;
    }
}
