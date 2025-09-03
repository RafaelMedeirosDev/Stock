package com.estudos.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.stock.domains.Employee;
import com.estudos.stock.respositories.EmployeeRepository;
import com.estudos.stock.services.employee.CreateEmployeeService;
import com.estudos.stock.shared.dtos.CreateEmployeeDto;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired 
    private CreateEmployeeService createEmployeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping()
    public ResponseEntity<Employee> register(@RequestBody CreateEmployeeDto body){
        Employee employee = this.createEmployeeService.execute(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping
    public  List<Employee> allEmployees(){
        return this.employeeRepository.getAllEmployees();
    }
}
