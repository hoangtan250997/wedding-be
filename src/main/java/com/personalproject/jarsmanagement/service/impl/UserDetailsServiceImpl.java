package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.User;
import com.personalproject.jarsmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return UserDetailsImpl.build(user);
    }

    @Transactional
    public UserDetails validateUser(String username) {
        User user = userRepository.findByUsername(username);
        return UserDetailsImpl.build(user);
    }
}