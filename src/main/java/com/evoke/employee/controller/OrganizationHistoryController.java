package com.evoke.employee.controller;

import com.evoke.employee.dto.OrganizationHistoryDto;
import com.evoke.employee.mappers.OrganizationHistoryMapper;
import com.evoke.employee.service.OrganizationHostoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganizationHistoryController {

    @Autowired
    private OrganizationHostoryService organizationHostoryService;

    @Autowired
    private OrganizationHistoryMapper mapper;

    @PostMapping("/org-history")
    public ResponseEntity<OrganizationHistoryDto> saveOrganizationHistory(@RequestBody OrganizationHistoryDto organizationHistoryDto){
           return  ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(organizationHostoryService.saveOrganizationHistory(mapper.toEntity(organizationHistoryDto))));
    }

    @GetMapping("/org-history")
    public ResponseEntity<List<OrganizationHistoryDto>> getHistory(){
        return ResponseEntity.ok(mapper.toDto(organizationHostoryService.getHisotry()));
    }
}
