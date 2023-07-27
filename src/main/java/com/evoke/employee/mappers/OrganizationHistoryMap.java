package com.evoke.employee.mappers;

import com.evoke.employee.dto.OrganizationHistoryDto;
import com.evoke.employee.model.OrganizationHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class OrganizationHistoryMap {
    public OrganizationHistoryDto toDto(OrganizationHistory organizationHistory){
        OrganizationHistoryDto organizationHistoryDto=new OrganizationHistoryDto();
        organizationHistoryDto.setId(organizationHistory.getId());
        organizationHistoryDto.setOrganizationName(organizationHistory.getOrganizationName());
        return organizationHistoryDto;
    }
}
