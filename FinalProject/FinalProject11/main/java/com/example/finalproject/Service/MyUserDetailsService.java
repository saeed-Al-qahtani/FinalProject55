package com.example.finalproject.Service;

import com.example.finalproject.Repository.UserRepository;
import com.example.finalproject.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findUserByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return user;
    }

        }




