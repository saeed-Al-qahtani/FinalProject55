package com.example.finalproject.Service;


import com.example.finalproject.Exception.ApiException;
import com.example.finalproject.Repository.CustomerRepository;
import com.example.finalproject.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    public void setCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public void updateCustomer(Integer id , Customer customer) {
        Customer oldCustomer= customerRepository.getById(id);
        oldCustomer.setName(customer.getName());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPhoneNumber(customer.getPhoneNumber());
        oldCustomer.setAge(customer.getAge());
        customerRepository.save(oldCustomer);
    }
    public void deleteCustomer(Integer id) {
        Customer customer=customerRepository.getById(id);
        customerRepository.delete(customer);
    }
    public Customer getCustomerById(Integer id) {
        Customer customer= customerRepository.findCustomerById(id);
        if(customer==null){
            throw new ApiException("Wrong user ID!");
        }
        return customer;

    }
    public Customer getCustomerByEmail(String email) {
        Customer customer= customerRepository.findCustomerByEmail(email);
        if(customer==null){
            throw new ApiException("Wrong user ID!");
        }
        return customer;

    }
    public Customer getCustomerByPhoneNumber(String phoneNumber) {
        Customer customer= customerRepository.findCustomerByPhoneNumber(phoneNumber);
        if(customer==null){
            throw new ApiException("Wrong user ID!");
        }
        return customer;

    }
    public List<Customer> getCustomerByGreaterAge(Integer age) {
        List <Customer> customer = customerRepository.findByAgeGreaterThan(age);
        if(customer==null){
            throw new ApiException("Wrong user ID!");
        }
        return customer;

    }
    public List<Customer> getCustomerByLessAge(Integer age) {
        List <Customer> customer= customerRepository.findByAgeLessThan(age);
        if(customer==null){
            throw new ApiException("Wrong user ID!");
        }
        return customer;
    }
    public List<Customer> getCustomerByRole(String role) {
        List <Customer> customer= customerRepository.findCustomerByRole(role);
        if(customer==null){
            throw new ApiException("Wrong user ID!");
        }
        return customer;
    }









}
