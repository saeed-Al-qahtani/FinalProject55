package com.example.finalproject.Repository;

import com.example.finalproject.model.Customer;
import com.example.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerById(Integer id);
    Customer findCustomerByEmail(String email);
    Customer findCustomerByPhoneNumber(String phoneNumber);

    List<Customer> findByAgeGreaterThan(Integer age);

    List<Customer> findByAgeLessThan(Integer age);

    List<Customer>findCustomerByRole(String role);


}
