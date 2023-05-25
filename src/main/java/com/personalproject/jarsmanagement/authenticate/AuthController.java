package com.personalproject.jarsmanagement.authenticate;


import com.personalproject.jarsmanagement.entity.User;
import com.personalproject.jarsmanagement.jwt.JwtRequest;
import com.personalproject.jarsmanagement.service.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")

public interface AuthController {
    @PostMapping("/signin")
    ResponseEntity<?> authenticateUser(@Valid @RequestBody JwtRequest loginRequest);
    @PostMapping(value = "/signup")
    ResponseEntity<User> createAccount(@RequestBody UserDTO userDTO) ;

}
