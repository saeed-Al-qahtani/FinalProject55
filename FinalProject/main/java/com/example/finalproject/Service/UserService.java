package com.example.finalproject.Service;


import com.example.finalproject.DTO.RegisterForm;
import com.example.finalproject.Repository.UserRepository;
import com.example.finalproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void register(RegisterForm registerForm){
        String hashedPassword= new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedPassword);

    }
    private ArrayList<User> usersList = new ArrayList<>();

    public ArrayList<User> getUsers() {

        return usersList;
    }
    public void addUser(User user) {

        usersList.add(user);
    }
    public void updateUser(int index, User user)
    {
        usersList.set(index, user);
    }
    public void deleteUser(int index) {
        usersList.remove(index);
    }


}


