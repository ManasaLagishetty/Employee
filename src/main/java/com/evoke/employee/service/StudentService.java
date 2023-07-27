package com.evoke.employee.service;

import com.evoke.employee.model.Student;
import com.evoke.employee.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager entityManager;

    public void save(Student student) {
        studentRepository.save(student);
        entityManager.detach(student);
        student.setName("jjjjjjj");
       // studentRepository.save(student);
    }

    public List<Student> getStd() {
        return  studentRepository.findAll();
    }


    public void deleteStd(Long id) {
        studentRepository.deleteById(id);
    }

    public void updateStd(Student student) {
        studentRepository.save(student);

    }
}




