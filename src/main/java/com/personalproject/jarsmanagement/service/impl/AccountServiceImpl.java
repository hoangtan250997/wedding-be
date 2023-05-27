package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.entity.User;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.DTO.AccountDTO;
import com.personalproject.jarsmanagement.service.DTO.UserDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.UserService;
import com.personalproject.jarsmanagement.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final UserService userService;
    private final AccountRepository accountRepository;

    private final MoneyJarService moneyJarService;


    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        //UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setRoles(accountDTO.getRoles());
        userDTO.setPassword(accountDTO.getPassword());
        userDTO.setUsername(accountDTO.getUsername());
        userDTO.setActive(accountDTO.isActive());

        //Create User
        User user=  userService.createUser(userDTO);

        //Create Account
        Account account = new Account();

        account.setUser(user);
        account.setEmail(accountDTO.getEmail());
        account.setFamily(accountDTO.getFamily());
        account.setLastName(accountDTO.getLastName());
        account.setFirstName(accountDTO.getFirstName());
        accountRepository.save(account);

        moneyJarService.createJars(account.getId());

        return AccountMapper.INSTANCE.mapToDto(account);
    }


}
