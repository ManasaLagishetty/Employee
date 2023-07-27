package com.evoke.employee.mappers;

import com.evoke.employee.dto.EmployeeDto;
import com.evoke.employee.model.Employee;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HobbiesMap.class,OrganizationHistoryMap.class})
public interface EmployeeMapper {

    Employee toEntity(EmployeeDto employeeDto);

    @Named("employee")
    @Mapping(target = "address.employee", ignore = true)
    @Mapping(target = "personalInformation.employee", ignore = true)
    @Mapping(target = "project.employee", ignore = true)
    EmployeeDto toDto(Employee employee);

    @IterableMapping(qualifiedByName = "employee")
    List<EmployeeDto> toDto(List<Employee> employee);

}
