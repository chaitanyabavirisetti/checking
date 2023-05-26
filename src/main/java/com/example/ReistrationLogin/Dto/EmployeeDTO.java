package com.example.ReistrationLogin.Dto;

import lombok.*;

@Builder

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class EmployeeDTO
{
    private int employeeid;
    private String employeename;
    private String email;
    private String password;
}
