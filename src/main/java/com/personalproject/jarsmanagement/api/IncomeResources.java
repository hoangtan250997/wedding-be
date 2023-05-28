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
//    @GetMapping("/incomesourcelist")
//    public List<String>listIncomeSourceByAccountId(@){
//        return incomeService.listIncomeSourceByAccountId(accountId);
//    }

    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody IncomeDTO incomeDTO,@PathVariable int accountId){
        return ResponseEntity.ok(incomeService.createIncome(incomeDTO,accountId));
    }

//    @GetMapping
//    public List<IncomeDTO> findByIncomeSourceIdAndAccountId(@RequestParam int incomeSourceId,@PathVariable int accountId){
//
//        //Throw JarsManagementException
//        if (incomeSourceId <= 0) throw JarsManagementException.badRequest("WrongFormat","Income Source Id must greater than 0");
//        if (accountId <= 0) throw JarsManagementException.badRequest("WrongFormat","Account Id must greater than 0");
//
//        return incomeService.findByIncomeSourceIdAndAccountId(incomeSourceId,accountId);
//    }

}

