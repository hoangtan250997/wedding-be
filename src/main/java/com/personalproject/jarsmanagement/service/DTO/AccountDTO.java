package com.personalproject.jarsmanagement.service.DTO;

import com.personalproject.jarsmanagement.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class AccountDTO {
    private String username;
    private String password;
    private boolean active;
    private List<Role> role;
    private String firstName;
    private String lastName;
    private String email;
    private String family;
}
