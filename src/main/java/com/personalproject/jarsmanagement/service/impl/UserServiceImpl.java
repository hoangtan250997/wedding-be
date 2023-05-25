package com.personalproject.jarsmanagement.service.impl;


import com.personalproject.jarsmanagement.entity.Role;
import com.personalproject.jarsmanagement.entity.User;
import com.personalproject.jarsmanagement.entity.UserRoleAssignment;
import com.personalproject.jarsmanagement.repository.UserRepository;
import com.personalproject.jarsmanagement.service.DTO.UserDTO;
import com.personalproject.jarsmanagement.service.UserService;
import com.personalproject.jarsmanagement.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getUsers() {
        return UserMapper.INSTANCE.mapToDtos(userRepository.findAll());
    }
    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setActive(userDTO.isActive());

        List<UserRoleAssignment> userRoleAssignmentList = new ArrayList<>();

        if (userDTO.getRole() == null) {
            UserRoleAssignment userRoleAssignment = new UserRoleAssignment();
            userRoleAssignment.setUsers(user);
            userRoleAssignment.setRole(Role.CHILD);
            userRoleAssignmentList.add(userRoleAssignment);

        }   else {
            for (Role r : userDTO.getRole()
            ) {
                UserRoleAssignment userRoleAssignment = new UserRoleAssignment();
                userRoleAssignment.setUsers(user);
                userRoleAssignment.setRole(r);
                userRoleAssignmentList.add(userRoleAssignment);
            }
        }
        user.setRoles(userRoleAssignmentList);
        return userRepository.save(user);
    }


    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();

    }

    @Override
    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

}
