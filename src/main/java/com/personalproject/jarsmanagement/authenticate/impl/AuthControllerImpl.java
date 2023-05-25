package com.personalproject.jarsmanagement.authenticate.impl;


import com.personalproject.jarsmanagement.authenticate.AuthController;
import com.personalproject.jarsmanagement.entity.User;
import com.personalproject.jarsmanagement.jwt.JwtRequest;
import com.personalproject.jarsmanagement.jwt.JwtResponse;
import com.personalproject.jarsmanagement.jwt.JwtUtils;
import com.personalproject.jarsmanagement.repository.UserRepository;
import com.personalproject.jarsmanagement.service.DTO.UserDTO;
import com.personalproject.jarsmanagement.service.UserService;
import com.personalproject.jarsmanagement.service.impl.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    public ResponseEntity<?> authenticateUser(JwtRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                roles));
    }
    public ResponseEntity<User> createAccount( UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

}
