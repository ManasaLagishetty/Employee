package com.evoke.employee.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="personal_info")
public class PersonalInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender;
    private String maritalStatus;
    private String nationality;
    private String dateOfBirth;

    @OneToOne
    @JoinColumn(name ="employee_id")
    private Employee employee;

    @Column(name="employee_id",insertable = false,updatable = false)
    private Long employeeId;
}
