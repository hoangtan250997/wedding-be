package com.personalproject.jarsmanagement.service.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private String password;
    private boolean active;
    private List<Role> roles;
}
