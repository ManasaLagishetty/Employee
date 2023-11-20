package com.evoke.employee.controller;

import com.evoke.employee.config.EmployeeDetails;
import com.evoke.employee.dto.EmployeeDto;
import com.evoke.employee.dto.EmployeePageDto;
import com.evoke.employee.dto.JwtResponse;
import com.evoke.employee.dto.LoginRequestDto;
import com.evoke.employee.mappers.EmployeeMapper;
import com.evoke.employee.model.Employee;
import com.evoke.employee.security.JWTHelper;
import com.evoke.employee.service.EmployeeService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CommonsLog
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeDetails userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTHelper jwtHelper;

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        String encryptedPwd= passwordEncoder.encode(employeeDto.getPassword());
        employeeDto.setPassword(encryptedPwd);
        log.info("creating employee");
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(employeeService.createEmployee(mapper.toEntity(employeeDto))));
    }

    @GetMapping("/employee")
    public ResponseEntity<EmployeePageDto> getEmployees(@RequestParam(value="pageNumber",defaultValue = "0",required=false) int pageNumber,
                                                         @RequestParam (value="pageSize",defaultValue = "2",required = false) int pageSize,
                                                         @RequestParam(value="sort",defaultValue = "email",required = false) String sort) {
       Page<Employee> employeePage= employeeService.getEmployee(pageNumber,pageSize,sort);

       EmployeePageDto employeePageDto=new EmployeePageDto();
       employeePageDto.setEmployee(mapper.toDto(employeePage.getContent()));
       employeePageDto.setTotalRecords(employeePage.getTotalElements());
       employeePageDto.setTotalPages(employeePage.getTotalPages());

        return ResponseEntity.ok(employeePageDto);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {

        return ResponseEntity.ok().body(mapper.toDto(employeeService.getEmployeeById(id).get()));
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
         employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/home")
    public String home(){
        return "logged in...";
    }

    @GetMapping("/message")
    public String message(){
        return "Hi";
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequestDto login){
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token= jwtHelper.generateToken(authentication);
        UserDetails userDetails=userDetailsService.loadUserByUsername(login.getEmail());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", "Bearer " + token);
        JwtResponse response= JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return ResponseEntity.ok().headers(responseHeaders).body(response);
    }

    @GetMapping("/log")
    public String writeLogs(){
        log.info("writing info");
        log.info("writing info");
        log.info("writing info");
        log.info("writing info");
        log.error("writing error");
        return  "logs saved";
    }

}
