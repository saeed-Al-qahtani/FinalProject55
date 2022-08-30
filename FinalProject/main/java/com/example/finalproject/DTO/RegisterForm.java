package com.example.finalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegisterForm {

    // User class
    private String username;
    private String password;
    private String role;

    // AdminSession class
    private String fullName;
    private String email;


    // DoctorSession class
    private String Speciality;
}