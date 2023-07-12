package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDTO;
import com.personalproject.jarsmanagement.service.IncomeSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/incomeSource")
public class IncomeSourceResources {
    private final IncomeSourceService incomeSourceService;
    private final AccountService accountService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    ResponseEntity<List<IncomeSourceDTO>> findAllIncomeSource() {
         return ResponseEntity.ok(incomeSourceService.findAllIncomeSource());
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN', 'PARENT','CHILD')")
    ResponseEntity<List<IncomeSourceDTO>> findByAccountId(@RequestHeader("Authorization") String token) {
        int accountId = accountService.getAccountFromToken(token).getId();
        if (accountId <= 0) throw JarsManagementException.badRequest("WrongFormat", "Account Id must greater than 0");
        return ResponseEntity.ok(incomeSourceService.findIncomeSourceByAccountId(accountId));
    }

    @PostMapping
    ResponseEntity<IncomeSourceDTO> createIncomeSource(@RequestParam String name, @RequestHeader("Authorization") String token) {

        Account account = accountService.getAccountFromToken(token);
            int accountId = account.getId();
            return ResponseEntity.ok(incomeSourceService.createIncomeSource(name, accountId));

    }

    @PutMapping("/{incomeSourceId}")
    ResponseEntity<IncomeSourceDTO> updateIncomeSource(@PathVariable int incomeSourceId, @RequestParam String newName) {
        return ResponseEntity.ok(incomeSourceService.updateIncomeSource(incomeSourceId, newName));
    }

    @PutMapping("/{incomeSourceId}/balance")
    ResponseEntity<IncomeSourceDTO> updateIncomeSourceBalance(@PathVariable int incomeSourceId, @RequestParam int balance) {
        return ResponseEntity.ok(incomeSourceService.updateIncomeSourceBalance(incomeSourceId, balance));
    }

    @GetMapping("/incomeSourceDetail")
    public List<IncomeSourceDTO> findByIncomeSourceNameAndAccountId(@RequestParam String name, @RequestHeader("Authorization") String token) {
        int accountId = accountService.getAccountFromToken(
                token).getId();
        return incomeSourceService.findByIncomeSourceNameAndAccountId(name, accountId);
    }


}
