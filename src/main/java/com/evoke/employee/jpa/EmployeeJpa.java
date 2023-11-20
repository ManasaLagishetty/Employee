package com.evoke.employee.jpa;

import com.evoke.employee.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EmployeeJpa {

    @Autowired
    EntityManager entityManager;

    public Employee findById(int id){
        return entityManager.find(Employee.class,id);
    }

    public List<Employee> findAll(){
       Query query= entityManager.createNamedQuery("select_all_employee");
       return query.getResultList();
    }

    public String deleteById(int id){
        Employee emp=findById(id);
        entityManager.remove(emp);
        return "deleted"+id ;
    }

    public Employee save(Employee emp){
        entityManager.persist(emp);
        return  emp;
    }

    public List<Employee> findAllJpql(){
        Query query= entityManager.createQuery("select e from Employee e");
        return query.getResultList();
    }


    public List<Employee> findAllNative(){
        Query query= entityManager.createNativeQuery("select * from employee", Employee.class);
        return query.getResultList();
    }


}
