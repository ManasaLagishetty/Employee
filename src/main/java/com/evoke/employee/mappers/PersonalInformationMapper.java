package com.evoke.employee.mappers;

import com.evoke.employee.dto.PersonalInformationDto;
import com.evoke.employee.model.PersonalInformation;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalInformationMapper {

    PersonalInformation toEntity(PersonalInformationDto personalInformationDto);

    @Named("personalInformation")
    @Mapping(target = "employee.personalInformation", ignore = true)
    @Mapping(target = "employee.hobbies", ignore = true)
    @Mapping(target = "employee.address", ignore = true)
    @Mapping(target = "employee.project", ignore = true)
    @Mapping(target = "employee.organizationHistories",ignore = true)
    PersonalInformationDto toDto(PersonalInformation personalInformation);

    @IterableMapping(qualifiedByName = "personalInformation")
    List<PersonalInformationDto> toDto(List<PersonalInformation> personalInformation);
}
