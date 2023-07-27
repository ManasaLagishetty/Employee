package com.evoke.employee.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String password;

    private Timestamp createdAt;

    @OneToOne(mappedBy = "employee")
    private PersonalInformation personalInformation;


    @OneToOne(mappedBy = "employee")
    private Address address;

    @OneToOne(mappedBy = "employee")
    private Project project;

    @OneToMany(mappedBy = "employee")
    private List<Hobbies> hobbies = Collections.emptyList();


    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private List<OrganizationHistory> organizationHistories;


    public Employee() {
    }

    public Employee(String email, String firstName, String lastName, String phoneNumber, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}
