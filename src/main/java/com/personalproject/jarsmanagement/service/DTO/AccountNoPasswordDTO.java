package com.personalproject.jarsmanagement.service.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.personalproject.jarsmanagement.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class AccountNoPasswordDTO {
    private int id;
    private String username;
    @JsonIgnore
    private String password;
    private boolean active;
    private List<Role> roles;
    private String firstName;
    private String lastName;
    private String email;
    private String family;
    private String photo;
}
