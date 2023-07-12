package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.DTO.Income.IdAmountIncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.IdAmountNameIncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.IncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.IncomeDetailsDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/income")
public class IncomeResources {
    private final IncomeService incomeService;
    private final AccountService accountService;
    @PostMapping
    public ResponseEntity<IncomeDTO> createIncome(@RequestBody IncomeDTO incomeDTO){
        return ResponseEntity.ok(incomeService.createIncome(incomeDTO));
    }

    @GetMapping("/periodDate")
    public ResponseEntity<List<IncomeDetailsDTO>> findByReceivedTimeBetween(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(incomeService.findByReceivedTimeBetween(start,end));
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/idAmountIncomeList")
    public ResponseEntity<List<IdAmountIncomeDTO>> listIdAmountIncomeDTO(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(incomeService.listIdAmountIncomeDTO(start,end));
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/idAmountNameIncomeList")
    public ResponseEntity<List<IdAmountNameIncomeDTO>> listIdAmountNameIncome(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(incomeService.listIdAmountNameIncome(start,end));
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'PARENT','CHILD')")
    @GetMapping("/idAmountIncome")
    public ResponseEntity<List<IdAmountIncomeDTO>> listIdAmountIncomeDTOByAccountId( @RequestHeader("Authorization") String token, @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        int accountId = accountService.getAccountFromToken(token).getId();
        return ResponseEntity.ok(incomeService.listIdAmountIncomeDTOByAccountId(start,end,accountId));
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'PARENT','CHILD')")
    @GetMapping("/idAmountNameIncome")
    public ResponseEntity<List<IdAmountNameIncomeDTO>> listIdAmountNameIncomeByAccountId( @RequestHeader("Authorization") String token, @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        int accountId = accountService.getAccountFromToken(token).getId();
        return ResponseEntity.ok(incomeService.listIdAmountNameIncomeByAccountId(start,end,accountId));
    }

}

