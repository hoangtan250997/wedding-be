package com.personalproject.jarsmanagement.service.DTO;

import com.personalproject.jarsmanagement.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String principalName;
    private String username;
    private String password;
    private boolean active;
    private List<Role> roles;
}
