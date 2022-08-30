package com.example.finalproject.Controller;


import com.example.finalproject.DTO.ApiResponse;
import com.example.finalproject.Service.CustomerService;
import com.example.finalproject.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/Customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService ;

    @GetMapping
    public ResponseEntity getCustomer(){
        return ResponseEntity.status(200).body(customerService.getCustomer());
    }
    @PostMapping
    public ResponseEntity setCustomer(@RequestBody @Valid Customer customer){
    customerService.setCustomer(customer);
    return ResponseEntity.status(201).body(new ApiResponse("customer Added ",201));

    }
    @PutMapping("/{id}")
    public ResponseEntity updateCustomer(@RequestBody @Valid Customer customer,@PathVariable Integer id){
        customerService.updateCustomer(id,customer);
        return ResponseEntity.status(201).body(new ApiResponse("customer updated",201));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable @Valid Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(201).body(new ApiResponse("customer deleted", 201));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable @Valid Integer id){
        Customer customer=customerService.getCustomerById(id);
        return ResponseEntity.status(200).body(customer);
    }
    @GetMapping("/email")
    public ResponseEntity<Customer> getCustomerByEmail(@RequestBody @Valid String email) {
        Customer customer = customerService.getCustomerByEmail(email);
        return ResponseEntity.status(200).body(customer);
    }
    @GetMapping("/phone")
    public ResponseEntity<Customer> getCustomerByPhoneNumber(@RequestBody @Valid String phoneNumber){
        Customer customer=customerService.getCustomerByPhoneNumber(phoneNumber);
        return ResponseEntity.status(200).body(customer);
    }
    @GetMapping("/age/greater")
    public ResponseEntity<List> getCustomerByGreaterAge(@RequestBody @Valid Integer age){
        List <Customer> customers=customerService.getCustomerByGreaterAge(age);
        return ResponseEntity.status(200).body(customers);
    }
    @GetMapping("/age/less")
    public ResponseEntity<List> getCustomerByLessAge(@RequestBody @Valid Integer age){
        List <Customer> customers=customerService.getCustomerByLessAge(age);
        return ResponseEntity.status(200).body(customers);
    }
    @GetMapping("/role")
    public ResponseEntity<List> getCustomerByRole(@RequestBody @Valid String role){
        List <Customer> customers=customerService.getCustomerByRole(role);
        return ResponseEntity.status(200).body(customers);
    }
}





