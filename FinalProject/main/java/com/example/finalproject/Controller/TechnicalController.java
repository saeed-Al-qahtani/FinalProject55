package com.example.finalproject.Controller;


import com.example.finalproject.DTO.ApiResponse;
import com.example.finalproject.Service.TechnicalService;
import com.example.finalproject.model.Technical;
import com.example.finalproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class TechnicalController {
    private final TechnicalService technicalService;

    @GetMapping("/Technical")
    public ResponseEntity getTechnical() {
        ArrayList<Technical> technicals = technicalService.getTechnical();
        return ResponseEntity.status(200).body(technicals);
    }

    @PostMapping("/Technical")
    public ResponseEntity addTechnical(@RequestBody @Valid Technical technical, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        technicalService.addTechnical(technical);
        return ResponseEntity.status(201).body(new ApiResponse("New Techni added !", 201));
    }




        }



