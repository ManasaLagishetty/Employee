package com.evoke.employee.controller;

import com.evoke.employee.dto.ProjectDto;
import com.evoke.employee.mappers.ProjectMapper;
import com.evoke.employee.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectMapper mapper;

    @PostMapping("/project")
    public ResponseEntity<ProjectDto> saveProjectDetails(@RequestBody ProjectDto project) {
       return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(projectService.saveProject(mapper.toEntity(project))));
    }
}
