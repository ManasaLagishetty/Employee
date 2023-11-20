package com.evoke.employee.config;

import com.evoke.employee.model.Employee;
import com.evoke.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDetails implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String username1=null;
        String password=null;
        List<GrantedAuthority> authorities= new ArrayList<>();
        Employee employee=employeeRepository.findByEmail(username).get();
        if(employee==null){
            throw new UsernameNotFoundException("user name not found"+username);
        }else {
        username1=  employee.getEmail();
        password=  employee.getPassword();
        }
        return new User(username1,password,authorities);
    }
}










