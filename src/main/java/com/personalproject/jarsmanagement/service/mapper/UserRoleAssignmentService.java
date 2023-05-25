package com.personalproject.jarsmanagement.service.mapper;

import com.personalproject.jarsmanagement.entity.UserRoleAssignment;
import com.personalproject.jarsmanagement.service.DTO.UserDTO;

import java.util.List;

public interface UserRoleAssignmentService {
    UserRoleAssignment createUser(UserDTO accountDto);

    List<UserRoleAssignment> getByUsername(String userName);
}
