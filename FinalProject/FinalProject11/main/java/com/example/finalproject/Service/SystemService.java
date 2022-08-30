package com.example.finalproject.Service;
import com.example.finalproject.Repository.SystemRepository;
import com.example.finalproject.model.Customer;
import com.example.finalproject.model.System;
import com.example.finalproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class SystemService {

    private final SystemRepository systemRepository;

    private ArrayList<System> systems = new ArrayList<>();

    public ArrayList<System> getSystem() {

        return systems;
    }
    public void addProblemType (System system, Customer customer) {

        systems.add(system);
    }
    public void addProblemDiscribe (System system, Customer customer) {

        systems.add(system);
    }

}
