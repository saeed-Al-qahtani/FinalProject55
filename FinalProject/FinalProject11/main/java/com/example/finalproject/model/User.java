package com.example.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User implements UserDetails
{
    @NotNull(message = "Id can't be null")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name can't be empty")
    private String username;
    @NotNull (message = "age can't be null")
    private Integer age;
    @NotEmpty(message = "password can't be empty")
    @Size(min = 6, max = 15, message = "password must be more than 6 char and less than 15 char")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",message = "please enter strong password")
    private String password;
    @NotNull(message = "Write the phone Number ")
    @Size(min = 10 ,  max=10 )
    private String PhoneNumber ;
    @NotEmpty(message = "role can not ot be empty")
    @Pattern(regexp = "(Customer|Technical)")
    private String role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
