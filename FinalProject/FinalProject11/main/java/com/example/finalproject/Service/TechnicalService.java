package com.example.finalproject.Service;

import com.example.finalproject.Exception.ApiException;
import com.example.finalproject.Repository.TechnicalRepository;
import com.example.finalproject.model.Technical;
import com.example.finalproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TechnicalService {
    private final TechnicalRepository technicalRepository;
    public List<Technical> getTechnical(){
        return technicalRepository.findAll();
    }
    public void setTechnical(Technical technical) {
        technicalRepository.save(technical);
    }

    public void updateTechnical(Integer id, Technical technical) {
        Technical oldTechnical=technicalRepository.getById(id);
        oldTechnical.setName(technical.getName());
        oldTechnical.setPhoneNumber(technical.getPhoneNumber());
        technicalRepository.save(oldTechnical);
    }
    public void deleteTechnical(Integer id) {
        Technical technical=technicalRepository.getById(id);
        technicalRepository.delete(technical);
    }
    public Technical getTechnicalById(Integer id) {
        Technical technical= technicalRepository.findTechnicalById(id);
        if(technical==null){
            throw new ApiException("Wrong user ID!");
        }
        return technical;
    }
    public Technical getTechnicalByPhoneNumber(String phoneNumber) {
        Technical technical = technicalRepository.findTechnicalByPhoneNumber(phoneNumber);
        if(technical==null){
            throw new ApiException("Wrong user phone number!");
        }
        return technical;
    }
    public List<Technical> getTechnicalByGreaterAge(Integer age) {
        List <Technical> technical = technicalRepository.findByAgeGreaterThan(age);
        if(technical==null){
            throw new ApiException("!");
        }
        return technical;
    }

    public List<Technical> getTechnicalByRole(String role) {
        List <Technical> technical = technicalRepository.findStudentByRole(role);
        if(technical==null){
            throw new ApiException("Wrong user school!");
        }
        return technical;
    }






}
