package com.example.EmployeeTodo.Response;

import com.example.EmployeeTodo.Entity.Employee;
import com.example.EmployeeTodo.dto.EmployeeDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EmployeeResponse implements RestResponse {
    public int status;
    public String message;
    private List<Employee> employee;
    private Object data;


    public EmployeeResponse() {
    }

    public EmployeeResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public EmployeeResponse(int status, String message, List<Employee> employee) {
        this.status = status;
        this.message = message;
        this.employee = employee;
    }

    public EmployeeResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
