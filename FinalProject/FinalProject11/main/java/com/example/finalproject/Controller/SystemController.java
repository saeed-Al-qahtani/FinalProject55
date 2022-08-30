package com.example.finalproject.Controller;

import com.example.finalproject.DTO.ApiResponse;
import com.example.finalproject.Service.SystemService;
import com.example.finalproject.model.Customer;
import com.example.finalproject.model.System;
import com.example.finalproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SystemController {
    private final SystemService systemService;
    @GetMapping("/mySystem")
    public ResponseEntity getSystem( @AuthenticationPrincipal User user){
        return ResponseEntity.status(200).body(systemService.getSystem());
    }
    @PostMapping("/system")
    public ResponseEntity addProblemType(@RequestBody  System system, @AuthenticationPrincipal Customer customer){
        systemService.addProblemType(system ,customer);
        return ResponseEntity.status(201).body(new ApiResponse("Problem Type added !",201));
    }
    @PostMapping("/systems")
    public ResponseEntity addProblemDiscribe(@RequestBody  System system, @AuthenticationPrincipal Customer customer){
        systemService.addProblemDiscribe(system,customer);
        return ResponseEntity.status(201).body(new ApiResponse("Problem Discribe added !",201));
    }


}
