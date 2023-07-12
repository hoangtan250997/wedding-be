package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.mapper.MoneyJarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/moneyJar")
public class MoneyJarResources {
    private final MoneyJarService moneyJarService;
    private final AccountService accountService;

    @GetMapping("/specifiedJar")
    ResponseEntity<MoneyJarDTO> findByAccountIAndJarType(@RequestHeader("Authorization") String token, @RequestParam int jarType) {
        int accountId = accountService.getAccountFromToken(token).getId();
        return ResponseEntity.ok(MoneyJarMapper.INSTANCE.mapToDto(moneyJarService.findByAccountIdAndJarType(accountId, jarType)));
    }

    @GetMapping("/{jarType}/balance")
    @PreAuthorize("hasAnyRole('ADMIN', 'PARENT','CHILD')")
    ResponseEntity<Double> getBalance(@RequestHeader("Authorization") String token, @PathVariable int jarType) {
        int accountId = accountService.getAccountFromToken(token).getId();
        return ResponseEntity.ok(moneyJarService.showBalance(jarType, accountId));
    }

    @PostMapping
    ResponseEntity<List<MoneyJarDTO>> createJar(@RequestHeader("Authorization") String token) {
        int accountId = accountService.getAccountFromToken(token).getId();
        return ResponseEntity.ok(MoneyJarMapper.INSTANCE.mapToDtos(moneyJarService.createJars(accountId)));
    }

    @PutMapping("/{moneyJarId}/balance")
    ResponseEntity<MoneyJarDTO> updateMoneyJarBalance(@PathVariable int moneyJarId, @RequestParam int balance) {
        log.info("UPDATE MONEY JAR  BALANCE ");
        return ResponseEntity.ok(moneyJarService.updateJarBalance(moneyJarId, balance));
    }

    @GetMapping
    ResponseEntity<List<MoneyJarDTO>> findByAccountId(@RequestHeader("Authorization") String token) {
        int accountId = accountService.getAccountFromToken(token).getId();
        return ResponseEntity.ok(moneyJarService.findByAccountId(accountId));
    }
}
