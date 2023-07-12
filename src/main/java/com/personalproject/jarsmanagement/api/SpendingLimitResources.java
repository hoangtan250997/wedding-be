package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.DTO.SpendingLimitDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.SpendingLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/moneyJar/{jarType}/limit")
public class SpendingLimitResources {
    private final SpendingLimitService spendingLimitService;
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<SpendingLimitDTO> createSpendingLimit(@RequestBody SpendingLimitDTO spendingLimitDTO, @RequestHeader("Authorization") String token, @PathVariable int jarType){
        int accountId = accountService.getAccountFromToken(token).getId();
        if (jarType> JarType.values().length) throw JarsManagementException.badRequest("NotFound","JarTypeNotFound");
        return ResponseEntity.ok(spendingLimitService.createSpendingLimit(spendingLimitDTO,accountId,jarType));
    }

}
