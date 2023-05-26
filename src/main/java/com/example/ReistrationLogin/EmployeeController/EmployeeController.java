package com.example.ReistrationLogin.EmployeeController;

import com.example.ReistrationLogin.Dto.EmployeeDTO;
import com.example.ReistrationLogin.Dto.LoginDTO;
import com.example.ReistrationLogin.Response.LoginResponse;
import com.example.ReistrationLogin.Response.RegisterResponse;
import com.example.ReistrationLogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@CrossOrigin

public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/save")
    public RegisterResponse saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @PostMapping(value ="/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
       LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);

       return ResponseEntity.ok(loginResponse);
   }



}
