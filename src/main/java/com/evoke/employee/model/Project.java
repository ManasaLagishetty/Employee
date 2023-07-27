package com.evoke.employee.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String reportingManager;
    private String role;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name="employee_id",insertable = false,updatable = false)
    private Long employeeId;

}
