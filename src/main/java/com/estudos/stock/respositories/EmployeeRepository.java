package com.estudos.stock.respositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estudos.stock.domains.Credential;
import com.estudos.stock.domains.Employee;;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> getByCredentialId (Credential credentialId);

    @Query(
        value= """
            SELECT 
                e.id,
                e.name,
                e.cpf,
                c.email,
                e.credential_id, 
                e.role
                FROM employee e 
                JOIN credential c ON c.id = e.credential_id
                """,
                     nativeQuery= true
    )
    List<Employee> getAllEmployees();
}
