package com.example.finalproject.Repository;


import com.example.finalproject.model.System;
import com.example.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemRepository extends JpaRepository<System,Integer> {
//    System findByProblemType(String ProblemType);
    //System findByProblemDiscrip(String ProblemDiscribe);
}


