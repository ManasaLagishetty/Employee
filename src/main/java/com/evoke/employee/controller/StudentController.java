package com.evoke.employee.controller;

import com.evoke.employee.model.Student;
import com.evoke.employee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping("/student")
    public List<Student> getStdnt(){
        return  studentService.getStd();
    }

    @DeleteMapping("/student/{id}")
    public void deleteStd(@PathVariable Long id){
        studentService.deleteStd(id);

    }

    @PutMapping("/student")
    public void updateStd(@RequestBody Student student){
        studentService.updateStd(student);
    }

}
