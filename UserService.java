package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(),passwordEncoder.encode(userDto.getPassword()),userDto.getFullname(), userDto.getRole());
        return userRepo.save(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll()
                .stream()
                .map(user -> new UserDto(user.getId(), user.getFullname(), user.getEmail()))
                .collect(Collectors.toList());
    }

}
