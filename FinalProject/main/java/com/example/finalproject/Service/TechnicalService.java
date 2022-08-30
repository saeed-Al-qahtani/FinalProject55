package com.example.finalproject.Service;

import com.example.finalproject.Repository.TechnicalRepository;
import com.example.finalproject.model.Technical;
import com.example.finalproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor

public class TechnicalService {
    private final TechnicalRepository technicalRepository;
    private ArrayList<Technical> technicals = new ArrayList<>();

    public ArrayList<Technical> getTechnical() {

        return technicals;
    }

    public void addTechnical(Technical technical) {

        technicals.add(technical);
    }

}
