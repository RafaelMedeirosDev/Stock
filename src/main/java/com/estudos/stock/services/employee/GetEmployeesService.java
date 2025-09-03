package com.estudos.stock.services.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Employee;
import com.estudos.stock.respositories.EmployeeRepository;

@Service
public class GetEmployeesService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> execute() {
        return this.employeeRepository.getAllEmployees();
    }
}
