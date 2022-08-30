package com.example.finalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
public class RegisterForm {
    @NotEmpty(message = "name can not ot be empty")
    private String name;
    @NotEmpty(message = "username can not ot be empty")
    private String username;
    @NotEmpty(message = "password can not ot be empty")
    private String password;
    @NotEmpty(message = "role can not be empty")
   @Pattern(regexp = "(Customer|Technical)")
    private String role;
    @NotEmpty(message = "Email can not ot be empty")
    @Email(message = "incorrect email")
    @Column(columnDefinition = "varchar(30) unique not null")
    private String email;
    @NotEmpty(message = "Phone number can not be empty")
    @Pattern(regexp = "/^[a-z]{0,10}$/")
    private String phoneNumber;
    @NotNull(message = "age can not be empty")
    private Integer age;
    @NotEmpty
    private String Experience;


}