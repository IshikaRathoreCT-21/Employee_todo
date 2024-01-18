package com.example.EmployeeTodo.Controller;

import com.example.EmployeeTodo.Entity.Employee;
import com.example.EmployeeTodo.Response.EmployeeResponse;
import com.example.EmployeeTodo.Service.EmployeeService;
import com.example.EmployeeTodo.contants.ConstantMessage;
import com.example.EmployeeTodo.contants.StatusCode;
import com.example.EmployeeTodo.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController

public class  EmployeeController {
    @Autowired
    private EmployeeService EmpService;
    @GetMapping("/fetchAllEmployee")
    public EmployeeResponse getEmployee(){
        List<Employee> employeeList = EmpService.fetchAllPerson();
        return new EmployeeResponse(StatusCode.SUCCESS, ConstantMessage.SUCCESSFUL_APPLICATION,employeeList);
    }
    @PostMapping("/creatingEmployee")
    public EmployeeResponse addEmployee(@RequestBody @Valid EmployeeDto employee,BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> errorMessage = new ArrayList<String>();
            for (Object object : bindingResult.getAllErrors()) {
                if (object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                    errorMessage.add(fieldError.getDefaultMessage());
                }
            }

            return new EmployeeResponse(StatusCode.BAD_REQUEST, ConstantMessage.BAD_REQUEST);

        } else {

            this.EmpService.createNewEmployee(employee);
            return new EmployeeResponse(StatusCode.SUCCESS, ConstantMessage.SUCCESSFUL_APPLICATION);
        }
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public EmployeeResponse deleteEmp(@PathVariable("id") int empId) {
           this.EmpService.deleteEmployee(empId);
            return new EmployeeResponse(StatusCode.SUCCESS, ConstantMessage.SUCCESSFUL_DELETION);
        }

    @PutMapping("/updateEmployee/{empID}")
        public EmployeeResponse updateEmp(@PathVariable("empID") int empID,@RequestBody @Valid EmployeeDto employee){
            this.EmpService.updateEmployee(empID, employee);
            return new EmployeeResponse(StatusCode.SUCCESS, ConstantMessage.SUCCESSFUL_APPLICATION);
        }

        @GetMapping("/getByFirstName/{searchText}")
        public EmployeeResponse searchEmp(@PathVariable("searchText") String string){
         List<Employee> employee=EmpService.searchByFirstName(string);
         return new EmployeeResponse(StatusCode.SUCCESS, ConstantMessage.SUCCESSFUL_APPLICATION, employee);
        }

    }





