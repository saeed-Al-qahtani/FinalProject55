package com.example.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class System {
    @Id
    @NotEmpty
    @Column(unique = true,nullable = false)
    private String problemType;
    @NotEmpty
    @Column(columnDefinition = "TEXT",nullable = false)// meannig write in bode it change from 255 char to 65555 char
    // nullable : meaning must be contain of content
    private String ProblemDiscrip;
}