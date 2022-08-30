package com.example.finalproject.Controller;

import com.example.finalproject.DTO.ApiResponse;
import com.example.finalproject.DTO.RegisterForm;
import com.example.finalproject.Service.UserService;
import com.example.finalproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        ArrayList<User> user = userService.getUsers();
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        userService.addUser(user);
        return ResponseEntity.status(201).body(new ApiResponse("New user added !", 201));
    }


    @PutMapping("/users/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid User user
            , @PathVariable int index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        userService.updateUser(index, user);
        return ResponseEntity.status(201).body(new ApiResponse("User updated !", 201));
    }

    @DeleteMapping("/users/{index}")
    public ResponseEntity deleteUser(@PathVariable int index) {
        userService.deleteUser(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted !", 200));
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body("Welcome back");

    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm) {
        userService.register(registerForm);
        return ResponseEntity.status(201).body("Register done !");
    }



}
