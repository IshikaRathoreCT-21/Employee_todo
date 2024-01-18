package com.example.EmployeeTodo.ServiceImpl;

import com.example.EmployeeTodo.Entity.Employee;
import com.example.EmployeeTodo.Repository.EmployeeRepository;
import com.example.EmployeeTodo.Service.EmployeeService;
import com.example.EmployeeTodo.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired

private EmployeeRepository EmpRepo;
    public Employee dtoToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setAddress(employeeDto.getAddress());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNo(employeeDto.getPhoneNo());
        employee.setAddress2(employeeDto.getAddress2());
        employee.setPassword(employeeDto.getPassword());
        employee.setPhoneNo2(employeeDto.getPhoneNo2());


        return employee;
    }

    public List<Employee> fetchAllPerson() {
        return (List<Employee>) this.EmpRepo.findAll();
    }
    public Employee createNewEmployee(EmployeeDto emp){
        Employee employee = dtoToEntity(emp);
        return EmpRepo.save(employee);
    }
    public void deleteEmployee(Integer id) {
       EmpRepo.deleteById(id);
    }

    public void updateEmployee(Integer id, EmployeeDto employee)
    {
        Employee employee1 = dtoToEntity(employee);
        employee.setId(id);
        EmpRepo.save(employee1);
    }
    public List<Employee> searchByFirstName(String str){
        return (List<Employee>) this.EmpRepo.findByfirstName(str);
    }
    public Employee findById(int id){
        return this.EmpRepo.findById(id);
    }


}


