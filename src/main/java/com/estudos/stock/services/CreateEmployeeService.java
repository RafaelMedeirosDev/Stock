package com.estudos.stock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.stock.domains.Credential;
import com.estudos.stock.domains.Employee;
import com.estudos.stock.respositories.EmployeeRepository;
import com.estudos.stock.shared.dtos.CreateEmployeeDto;

@Service
public class CreateEmployeeService {
    @Autowired
    private CreateCredentialService createCredentialService;
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee execute (CreateEmployeeDto data){
        Credential credential = this.createCredentialService.execute(data.email, data.password, data.role);
        return this.employeeRepository.save(new Employee(data.name, data.cpf, credential));
    }
}
