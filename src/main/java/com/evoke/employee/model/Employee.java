package com.evoke.employee.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
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

}
