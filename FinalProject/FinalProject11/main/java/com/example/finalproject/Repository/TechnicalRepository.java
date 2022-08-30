package com.example.finalproject.Repository;


import com.example.finalproject.model.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical , Integer> {
    Technical findTechnicalById(Integer id);
    Technical findTechnicalByPhoneNumber(String phoneNumber);
    List<Technical> findByAgeGreaterThan(Integer age);
    List<Technical> findStudentByRole(String role);

}




