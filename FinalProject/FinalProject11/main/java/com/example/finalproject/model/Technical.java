package com.example.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data @NoArgsConstructor @Entity
public class Technical {
    @NotNull(message = "Id can't be null")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name can't be empty")
    private String name;
    @NotNull(message = "Write the phone Number ")
    @Size(min = 10 ,  max=10 )
    private String PhoneNumber ;
    @NotEmpty
    private String Experience;
    @NotNull
    private Integer userId;

}
