package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private User user;
    public CustomUserDetails(User user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //using List.of to create immutable list of roles
        return List.of(()->user.getRole());
    }

    public String getFullname(){
        return user.getFullname();
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
    //Indicates whether the user's account has expired.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //Indicates whether the user is locked or unlocked.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // Indicates whether the user's password has expired.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //Indicates whether the user is enabled or disabled
    //A disabled user cannot be authenticated.
    @Override
    public boolean isEnabled() {
        return true;
    }
}
