package com.evoke.employee.controller;

import com.evoke.employee.dto.HobbiesDto;
import com.evoke.employee.mappers.HobbiesMapper;
import com.evoke.employee.service.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbiesController {

    @Autowired
    private HobbiesService hobbiesService;

    @Autowired
    private HobbiesMapper mapper;

    @PostMapping("/hobbies")
    public ResponseEntity<HobbiesDto> save(@RequestBody HobbiesDto hobbiesDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(hobbiesService.save(mapper.toEntity(hobbiesDto))));
    }

}
