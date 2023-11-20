package com.evoke.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

//    @Autowired
//    JdbcDao jdbcDao;
//
//    @Autowired
//    EmployeeJpa employeeJpa;
//
//    @Override
//    public void run(String... args) throws Exception {
//        //jdbc template
//        List<Employee> employeeList1 = jdbcDao.findAll();
//        for (Employee emp1 : employeeList1) {
//            System.out.println(emp1.getEmail());
//        }
//
//        // find by id jpa
//        Employee emp = employeeJpa.findById(1);
//        System.out.println(emp.getEmail());
//
//        // find all employees
//        List<Employee> employeeList = employeeJpa.findAll();
//        for (Employee emp1 : employeeList) {
//            System.out.println(emp1.getEmail());
//        }
//        // employee delete
//       // System.out.println(employeeJpa.deleteById(16));
//
//        //employee save
//        Employee employee = new Employee();
//        employee.setEmail("hjnjnj@gamil");
//        employee.setFirstName("guy8u");
//        employeeJpa.save(employee);
//
//        //jpql
//        System.out.println("jpql");
//        List<Employee> employeeList2 = employeeJpa.findAllJpql();
//        for (Employee emp2 : employeeList2) {
//            System.out.println(emp2.getEmail());
//        }
//        //native query
//        System.out.println("native query");
//        List<Employee> employeeList3 = employeeJpa.findAllNative();
//        for (Employee emp3 : employeeList3) {
//            System.out.println(emp3.getEmail());
//        }
}