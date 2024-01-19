package com.example.EmployeeTodo.dto;


import lombok.Data;
import org.intellij.lang.annotations.Pattern;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


@Data
@Validated
public class EmployeeDto {


    private int Id;
    @NotNull(message = "")
    private String firstName;
   // @NotBlank(message = "lastName can not be empty")
    private String lastName;
  //  @Email
    private String email;
    private String address;
    private String address2;
    private String phoneNo;
    private String phoneNo2;
   // @NotBlank(message = "Password can not be empty")
   // @Size(min = 8, message = "Password size must be atleast 8 characters long !")
    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)(?=.*[@#$%^&+=]).*[A-Za-z0-9]$")
    private String password;
}
