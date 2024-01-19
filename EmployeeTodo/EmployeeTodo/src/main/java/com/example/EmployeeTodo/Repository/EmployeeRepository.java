package com.example.EmployeeTodo.Repository;

import com.example.EmployeeTodo.Entity.Employee;
import com.example.EmployeeTodo.dto.EmployeeDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
List<Employee> findByfirstName(String str);
public Employee findById(int id);
boolean existsById(int id);

}
