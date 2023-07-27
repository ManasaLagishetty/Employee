package com.evoke.employee.controller;

import com.evoke.employee.dto.AddressDto;
import com.evoke.employee.mappers.AddressMapper;
import com.evoke.employee.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressMapper mapper;

    @PostMapping("/address")
    public ResponseEntity<AddressDto> saveAddress(@RequestBody AddressDto addressdto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(addressService.save(mapper.toEntity(addressdto))));
    }

    @GetMapping("/address")
    public ResponseEntity<List<AddressDto>> employeeAddress(){
       return ResponseEntity.ok(mapper.toDto(addressService.employeeAddress()));
    }

}
