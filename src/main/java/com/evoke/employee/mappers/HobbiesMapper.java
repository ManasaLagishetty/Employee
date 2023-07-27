package com.evoke.employee.mappers;

import com.evoke.employee.dto.HobbiesDto;
import com.evoke.employee.model.Hobbies;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HobbiesMapper {

    Hobbies toEntity(HobbiesDto hobbiesDto);

    @Mapping(target = "employee.hobbies", ignore = true)
    @Mapping(target = "employee.address", ignore = true)
    @Mapping(target = "employee.personalInformation", ignore = true)
    @Mapping(target = "employee.project", ignore = true)
    @Mapping(target = "employee.organizationHistories",ignore = true)
    HobbiesDto toDto(Hobbies hobbies);

}
