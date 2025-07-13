package com.estudos.stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.stock.domains.Employee;
import com.estudos.stock.respositories.EmployeeRepository;
import com.estudos.stock.services.CreateEmployeeService;
import com.estudos.stock.shared.dtos.CreateEmployeeDto;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired 
    private CreateEmployeeService createEmployeeService;

    @PostMapping()
    public Employee register(@RequestBody CreateEmployeeDto body){
        return this.createEmployeeService.execute(body);
    }
}
