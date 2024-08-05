package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

import java.util.List;

public interface IUserService {
    //save the new user or admin
    User save(UserDto userDto);
    //save the list of all users or admins
    List<UserDto> findAll();
}
