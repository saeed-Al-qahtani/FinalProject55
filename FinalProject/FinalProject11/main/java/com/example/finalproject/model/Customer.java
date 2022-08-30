package com.example.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "name can not be empty")
    private String name;

    @NotEmpty(message = "email can not be empty")
    @Email
    @Column(columnDefinition = "varchar(30) unique not null")
    private String email;


    @NotEmpty(message = "Phone number can not be empty")
    private String phoneNumber;


    @NotNull(message = "age can not be empty")
    private Integer age;

    @NotEmpty(message = "role can not be empty")
    @Pattern(regexp = "(Customer|Technical)")
    private String role;

    @NotNull
    private Integer userId;



}