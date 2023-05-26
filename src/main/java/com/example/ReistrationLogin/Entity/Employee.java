package com.example.ReistrationLogin.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class Employee
{
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeid;

    @Column(name = "employee_name")
    private String employeename;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public boolean isPresent() {
        return isPresent();
    }
}
