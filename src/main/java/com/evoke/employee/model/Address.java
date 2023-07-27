package com.evoke.employee.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String country;
    private String zipcode;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Long employeeId;

}
