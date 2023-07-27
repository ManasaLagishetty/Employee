package com.evoke.employee.mappers;


import com.evoke.employee.dto.ProjectDto;
import com.evoke.employee.model.Project;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project toEntity(ProjectDto projectDto);

    @Named("project")
    @Mapping(target = "employee.project", ignore = true)
    @Mapping(target = "employee.personalInformation", ignore = true)
    @Mapping(target = "employee.hobbies", ignore = true)
    @Mapping(target = "employee.address", ignore = true)
    @Mapping(target = "employee.organizationHistories",ignore = true)
    ProjectDto toDto(Project project);

    @IterableMapping(qualifiedByName = "project")
    List<ProjectDto> toDto(List<Project> project);
}
