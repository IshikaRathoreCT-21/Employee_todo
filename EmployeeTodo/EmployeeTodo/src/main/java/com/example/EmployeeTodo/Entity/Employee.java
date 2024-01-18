package com.example.EmployeeTodo.Entity;


import lombok.Data;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String address2;
    private String phoneNo;
    private String phoneNo2;
    private String password;


}
