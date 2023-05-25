package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.Account;
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
    ResponseEntity<List<Account>> findAllAccount(){
        return ResponseEntity.ok(accountService.findAllAccount());
    }



}
