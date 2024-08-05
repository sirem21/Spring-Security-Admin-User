package com.example.demo.dto;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//for transmitting the data that will be collected in controller
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private String role;
    private String fullname;

    public UserDto(Long id, String fullname, String email) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
    }
}

