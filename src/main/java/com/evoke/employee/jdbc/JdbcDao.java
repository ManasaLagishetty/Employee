package com.evoke.employee.jdbc;

import com.evoke.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> findAll(){
        return jdbcTemplate.query("select * from employee",new BeanPropertyRowMapper<>(Employee.class));
    }

}
