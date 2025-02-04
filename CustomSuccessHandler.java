package com.example.demo.service;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        // using var lombok annotation for not writing the type of authorites
        var authorities = authentication.getAuthorities();
        var roles = authorities.stream().map(r -> r.getAuthority()).findFirst();

        // redirect to different end-points for different roles
        if(roles.orElse("").equals("ADMIN")){
            response.sendRedirect("/admin-page");
        }
        else if (roles.orElse("").equals("USER")) {
            response.sendRedirect("/user-page");
        }
        else {
            response.sendRedirect("/error");
        }
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{

    }
}
