package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
//create the table in db with the user's information
//using the uniqueConstraints for non-repeated emails
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String role;
    private String fullname;

    public User(String email, String password,String fullname,String role) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.role = determineRoles(email);
    }

    private String determineRoles(String email) {
        if (email.contains("@admin")) {
            return ("ADMIN");
        }
        return ("USER");
    }
}
