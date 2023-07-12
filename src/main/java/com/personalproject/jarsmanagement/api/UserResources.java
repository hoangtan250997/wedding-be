package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.service.DTO.UserDTO;
import com.personalproject.jarsmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserResources {
    private final UserService userService;
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.getUsers());
    }

}
