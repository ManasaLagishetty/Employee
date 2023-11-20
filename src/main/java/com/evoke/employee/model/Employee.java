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
@NamedQuery(name ="select_all_employee",query = "select e from Employee e")
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

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private PersonalInformation personalInformation;


    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private Project project;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Hobbies> hobbies = Collections.emptyList();


    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private List<OrganizationHistory> organizationHistories;

}
