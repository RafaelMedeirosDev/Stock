package com.estudos.stock.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.stock.domains.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> getByCredentialId (String credentialId);
}
