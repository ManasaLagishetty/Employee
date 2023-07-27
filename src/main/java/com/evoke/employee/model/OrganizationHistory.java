package com.evoke.employee.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name="organization_history")
public class OrganizationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String organizationName;

    @ManyToMany
    @JoinTable(
            name="employee_organization_history",
            joinColumns = @JoinColumn(name="organization_id"),
            inverseJoinColumns = @JoinColumn(name="employee_id")
    )
    private List<Employee> employees;

}
