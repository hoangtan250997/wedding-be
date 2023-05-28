package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.service.DTO.AccountDTO;

import java.util.List;

public interface AccountService {
    Account findById(int id);
    List<AccountDTO> findAllAccount();
    AccountDTO createAccount(AccountDTO accountDTO);

}
