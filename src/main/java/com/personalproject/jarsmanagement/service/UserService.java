package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.User;
import com.personalproject.jarsmanagement.service.DTO.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();


    User findById(int id);

    User findByUsername(String userName);


}
