package com.example.finalproject.Service;


import com.example.finalproject.DTO.RegisterForm;
import com.example.finalproject.Repository.CustomerRepository;
import com.example.finalproject.Repository.TechnicalRepository;
import com.example.finalproject.Repository.UserRepository;
import com.example.finalproject.model.Customer;
import com.example.finalproject.model.Technical;
import com.example.finalproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final TechnicalRepository technicalRepository;

    public void register(RegisterForm registerForm) {
        String hashedPassword = new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedPassword);
        User user = new User(null, registerForm.getUsername(), registerForm.getAge(), registerForm.getPassword(), registerForm.getPhoneNumber()
                , registerForm.getRole());
        User newUser = userRepository.save(user);

        if (registerForm.getRole().equals("Customer")) {
            Customer customer = new Customer
                    (null, registerForm.getName(), registerForm.getEmail(), registerForm.getPhoneNumber(),
                            registerForm.getAge(), registerForm.getRole(), newUser.getId());
            customerRepository.save(customer);
        }
        else {
            Technical technical = new Technical(null, registerForm.getName(), registerForm.getPhoneNumber(),
                    registerForm.getRole(), newUser.getId());
            technicalRepository.save(technical);
        }


    }
}



