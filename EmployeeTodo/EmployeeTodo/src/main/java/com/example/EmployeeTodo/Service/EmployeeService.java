package com.example.EmployeeTodo.Service;

import com.example.EmployeeTodo.Entity.Employee;
import com.example.EmployeeTodo.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public List<Employee> fetchAllPerson();
    public Employee createNewEmployee(EmployeeDto emp);
    public void deleteEmployee(Integer id);
    public void updateEmployee(Integer id, EmployeeDto emp);
    public List<Employee> searchByFirstName(String str);
    public boolean idExists(int id);

}
