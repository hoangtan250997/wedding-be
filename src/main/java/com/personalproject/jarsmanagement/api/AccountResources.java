package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.DTO.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountResources {
    private final AccountService accountService;

    @GetMapping
    ResponseEntity<List<AccountDTO>> findAllAccount() {
        return ResponseEntity.ok(accountService.findAllAccount());
    }

    @PostMapping
    ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        if (accountDTO.getPassword().isEmpty())
            throw JarsManagementException.badRequest("PasswordEmpty", "Password is empty");
        return ResponseEntity.ok(accountService.createAccount(accountDTO));
    }

    @PutMapping("/{accountId}")
    ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO, @PathVariable int accountId) {
        return ResponseEntity.ok(accountService.updateAccount(accountDTO,accountId));
    }


}
