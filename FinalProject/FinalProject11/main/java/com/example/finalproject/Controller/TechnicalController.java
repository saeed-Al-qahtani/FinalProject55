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
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Technical")
public class TechnicalController {
    private final TechnicalService technicalService;

    @GetMapping
    public ResponseEntity getTechnical() {
        return ResponseEntity.status(200).body(technicalService.getTechnical());
    }

    @PostMapping
    public ResponseEntity setTechnical(@RequestBody @Valid Technical technical){
        technicalService.setTechnical(technical);
        return ResponseEntity.status(201).body(new ApiResponse("Technical saved",200));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateTechnical(@RequestBody @Valid Technical technical,@PathVariable Integer id){
        technicalService.updateTechnical(id,technical);
        return ResponseEntity.status(201).body(new ApiResponse("Technical updated",200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTechnical(@PathVariable @Valid Integer id){
        technicalService.deleteTechnical(id);
        return ResponseEntity.status(201).body(new ApiResponse("Technical deleted",200));

    }
    @GetMapping("/id")
    public ResponseEntity<Technical> getTechnicalById(@RequestParam  Integer id){
        Technical technical=technicalService.getTechnicalById(id);
        return ResponseEntity.status(200).body(technical);
    }

    @GetMapping("/phone")
    public ResponseEntity<Technical> getTechnicalByPhoneNumber(@RequestParam  String phoneNumber){
        Technical technical=technicalService.getTechnicalByPhoneNumber(phoneNumber);
        return ResponseEntity.status(200).body(technical);
    }


    @GetMapping("/role")
    public ResponseEntity<List> getTechnicalByRole(@RequestParam  String role){
        List <Technical> technical=technicalService.getTechnicalByRole(role);
        return ResponseEntity.status(200).body(technical);
    }


}



