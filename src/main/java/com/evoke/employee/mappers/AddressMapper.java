package com.evoke.employee.mappers;

import com.evoke.employee.dto.AddressDto;
import com.evoke.employee.model.Address;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressDto addressDto);

    @Named("address")
    @Mapping(target = "employee.address", ignore = true)
    @Mapping(target = "employee.project", ignore = true)
    @Mapping(target = "employee.personalInformation", ignore = true)
    @Mapping(target = "employee.hobbies", ignore = true)
    @Mapping(target = "employee.organizationHistories",ignore = true)
    AddressDto toDto(Address address);

    @IterableMapping(qualifiedByName = "address")
    List<AddressDto> toDto(List<Address> address);

}
