package com.evoke.employee.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
public class EmployeeDto {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String password;

    private Timestamp createdAt;

    private AddressDto address;

    private ProjectDto project;

    private PersonalInformationDto personalInformation;

    private List<HobbiesDto> hobbies = Collections.emptyList();

    private List<OrganizationHistoryDto> organizationHistories=Collections.emptyList();

}


