package com.personalproject.jarsmanagement.service.DTO;

import com.personalproject.jarsmanagement.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleAssignmentDTO {
    private Integer userId;
    private Role role;

}
