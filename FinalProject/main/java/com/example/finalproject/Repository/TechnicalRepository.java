package com.example.finalproject.Repository;


import com.example.finalproject.model.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical , Integer> {
//    Technical findTechnicalById(Integer id);
//    Technical findTechnicalByEmail(String Email);


}

