package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.service.DTO.Cau2;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.mapper.IncomeMapper;
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
    public ResponseEntity<Income> createIncome(@RequestBody IncomeDTO incomeDTO,@PathVariable int accountId){
        if (accountId<=0) throw JarsManagementException.badRequest("WrongFormat","accountId must be greater than 0");
        return ResponseEntity.ok(incomeService.createIncome(incomeDTO,accountId));
    }

    @GetMapping("/periodDate")
    public ResponseEntity<List<IncomeDTO>> findByReceivedTimeBetween(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(IncomeMapper.INSTANCE.mapToDtos(incomeService.findByReceivedTimeBetween(start,end)));
    }
    @GetMapping("/periodDateTotal")
    public ResponseEntity<Double> totalIncomeBetweenTwoDay(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(incomeService.totalIncomeBetweenTwoDay(start,end));
    }

    @GetMapping("/cau2")
    public ResponseEntity<List<Cau2>> cau2(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(incomeService.cau2(start,end));
    }




}

