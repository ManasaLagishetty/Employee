package com.evoke.employee.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="hobbies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hobbies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hobby;

    @ManyToOne
    @JoinColumn(name ="employee_id")
    private Employee employee;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Long employeeId;

}
