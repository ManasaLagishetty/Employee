package com.evoke.employee.mappers;

import com.evoke.employee.dto.OrganizationHistoryDto;
import com.evoke.employee.model.OrganizationHistory;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmployeeMap.class)
public interface OrganizationHistoryMapper {

    OrganizationHistory toEntity(OrganizationHistoryDto organizationHistoryDto);

    @Named("organization")
//    @Mapping(target = "employee.address", ignore = true)
//    @Mapping(target = "employee.project", ignore = true)
//    @Mapping(target = "employee.personalInformation", ignore = true)
//    @Mapping(target = "employee.hobbies", ignore = true)
    OrganizationHistoryDto toDto(OrganizationHistory organizationHistory);

    @IterableMapping(qualifiedByName = "organization")
    List<OrganizationHistoryDto> toDto(List<OrganizationHistory> organizationHistories);

}
