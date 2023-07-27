package com.evoke.employee.controller;

import com.evoke.employee.dto.PersonalInformationDto;
import com.evoke.employee.mappers.PersonalInformationMapper;
import com.evoke.employee.model.PersonalInformation;
import com.evoke.employee.service.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonalInformationController {

    @Autowired
    private PersonalInformationService personalInformationService;

    @Autowired
    private PersonalInformationMapper mapper;

    @PostMapping("/personal-info")
    public ResponseEntity<PersonalInformationDto> savePersonalInfo(@RequestBody PersonalInformationDto personalInfoDto){
       return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(personalInformationService.savePersonalInfo(mapper.toEntity(personalInfoDto))));
    }

    @GetMapping("/personal-info")
    public ResponseEntity<List<PersonalInformation>> getInfo(){
        return ResponseEntity.ok(personalInformationService.getInfo());
    }
}
