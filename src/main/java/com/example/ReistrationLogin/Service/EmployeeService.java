package com.example.ReistrationLogin.Service;

import com.example.ReistrationLogin.Dto.EmployeeDTO;
import com.example.ReistrationLogin.Dto.LoginDTO;
import com.example.ReistrationLogin.Response.LoginResponse;
import com.example.ReistrationLogin.Response.RegisterResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@SpringBootApplication

@Configuration
@Service


public interface EmployeeService
{


    RegisterResponse addEmployee(EmployeeDTO employeeDTO);


    LoginResponse loginEmployee(LoginDTO loginDTO);
}
