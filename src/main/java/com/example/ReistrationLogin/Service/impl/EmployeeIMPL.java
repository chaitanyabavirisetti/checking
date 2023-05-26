package com.example.ReistrationLogin.Service.impl;


import com.example.ReistrationLogin.Dto.EmployeeDTO;
import com.example.ReistrationLogin.Dto.LoginDTO;
import com.example.ReistrationLogin.Entity.Employee;
import com.example.ReistrationLogin.Repositary.EmployeeRepo;
import com.example.ReistrationLogin.Response.LoginResponse;
import com.example.ReistrationLogin.Response.RegisterResponse;
import com.example.ReistrationLogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
@SpringBootApplication
@Service
public class EmployeeIMPL implements EmployeeService
{
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public RegisterResponse addEmployee(EmployeeDTO employeeDTO)
    {
        if (employeeDTO.getPassword() == null || employeeDTO.getPassword().isEmpty()
                || employeeDTO.getEmail() == null || employeeDTO.getEmail().isEmpty())
        {
            return new RegisterResponse("Registration Failed: Missing required data", false);
        }
        Employee employee = new Employee
                (
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
                );
        Employee savedEmployee = employeeRepo.save(employee);
        if (savedEmployee != null)
        {
            return new RegisterResponse("registration success",true);
        } else
        {
            return  new RegisterResponse("Registration Failed", false);
        }


       /* Employee employee = new Employee(

                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),

                this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepo.save(employee);

        return employee.getEmployeename();
    }
    EmployeeDTO employeeDTO;
        if (employee.isPresent())
        {
            return new RegisterResponse("register success", true);
        }else
        {
            return new RegisterResponse("register failed", false);
        }
*/
    }
    EmployeeDTO employeeDTO;
    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null)
        {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else
            {

                return new LoginResponse("password Not Match", false);
            }
        }else
        {
            return new LoginResponse("Email not exits", false);
        }


    }

}
