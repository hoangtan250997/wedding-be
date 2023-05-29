package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.entity.Role;
import com.personalproject.jarsmanagement.entity.User;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.DTO.AccountDTO;
import com.personalproject.jarsmanagement.service.DTO.UserDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.UserService;
import com.personalproject.jarsmanagement.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    private final UserService userService;
    private final MoneyJarService moneyJarService;


    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public List<AccountDTO> findAllAccount() {
        return AccountMapper.INSTANCE.mapToDtos(accountRepository.findAll());
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {


        //UserDTO from accountDTO -> create User
        UserDTO userDTO = new UserDTO();
        userDTO.setRoles(accountDTO.getRoles());
        userDTO.setPassword(accountDTO.getPassword());
        userDTO.setUsername(accountDTO.getUsername());
        userDTO.setActive(accountDTO.isActive());

        //Create User
        log.info("Create an user from Account");
        User user = userService.createUser(userDTO);
        //Create Account
        Account account = new Account();

        account.setUser(user);
        account.setEmail(accountDTO.getEmail());
        account.setFamily(accountDTO.getFamily());
        account.setLastName(accountDTO.getLastName());
        account.setFirstName(accountDTO.getFirstName());

        //Automatically create 7jars when an account is set up
        moneyJarService.createJars(accountRepository.save(account).getId());

        return AccountMapper.INSTANCE.mapToDto(accountRepository.save(account));

    }

    @Override
    public AccountDTO updateAccount(AccountDTO accountDTO, int accountId) {
        log.info("UPDATE ACCOUNT");
        Account account = accountRepository.findById(accountId).orElseThrow(JarsManagementException::AccountNotFound);
        log.info("FOUND ACCOUNT");

        if (accountDTO.getFirstName() != null) account.setFirstName(accountDTO.getFirstName());
        if (accountDTO.getLastName() != null) account.setLastName(accountDTO.getLastName());
        if (accountDTO.getEmail() != null) account.setEmail(accountDTO.getEmail());
        if (accountDTO.getPhoto() != null) account.setPhoto(accountDTO.getPhoto());

        return AccountMapper.INSTANCE.mapToDto(accountRepository.save(account));
    }


}
