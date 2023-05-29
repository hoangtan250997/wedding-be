package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.service.DTO.Income.IdAmountIncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.idAmountNameIncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.IncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.IncomeDetailsDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{accountId}/income")
public class IncomeResources {
    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<IncomeDTO> createIncome(@RequestBody IncomeDTO incomeDTO,@PathVariable int accountId){
        if (accountId<=0) throw JarsManagementException.badRequest("WrongFormat","accountId must be greater than 0");
        return ResponseEntity.ok(incomeService.createIncome(incomeDTO,accountId));
    }

    @GetMapping("/periodDate")
    public ResponseEntity<List<IncomeDetailsDTO>> findByReceivedTimeBetween(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(incomeService.findByReceivedTimeBetween(start,end));
    }

    @GetMapping("/idAmountIncomeList")
    public ResponseEntity<List<IdAmountIncomeDTO>> listIdAmountIncomeDTO(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(incomeService.listIdAmountIncomeDTO(start,end));
    }

    @GetMapping("/idAmountNameIncomeList")
    public ResponseEntity<List<idAmountNameIncomeDTO>> listIdAmountNameIncome(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(incomeService.listIdAmountNameIncome(start,end));
    }

    @GetMapping("/idAmountIncome")
    public ResponseEntity<List<IdAmountIncomeDTO>> listIdAmountIncomeDTOByAccountId(@PathVariable int accountId, @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(incomeService.listIdAmountIncomeDTOByAccountId(start,end,accountId));
    }

    @GetMapping("/idAmountNameIncome")
    public ResponseEntity<List<idAmountNameIncomeDTO>> listIdAmountNameIncomeByAccountId(@PathVariable int accountId, @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(incomeService.listIdAmountNameIncomeByAccountId(start,end,accountId));
    }




}

