package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDTO;
import com.personalproject.jarsmanagement.service.IncomeSourceService;
import com.personalproject.jarsmanagement.service.mapper.IncomeSourceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/{accountId}/incomeSource")
public class IncomeSourceResources {
    private final IncomeSourceService incomeSourceService;

    @GetMapping
    ResponseEntity<List<IncomeSourceDTO>> findAllIncomeSource(){
        return ResponseEntity.ok(incomeSourceService.findAllIncomeSource());
    }
    @GetMapping("/list")
    ResponseEntity<List<IncomeSourceDTO>> findByAccountId(@PathVariable int accountId){
        if (accountId <= 0) throw JarsManagementException.badRequest("WrongFormat","Account Id must greater than 0");
        return ResponseEntity.ok(incomeSourceService.findIncomeSourceByAccountId(accountId));
    }
    @PostMapping
    ResponseEntity<IncomeSourceDTO> createIncomeSource(@RequestParam String name, @PathVariable int accountId){
        if (accountId <= 0) throw JarsManagementException.badRequest("WrongFormat","Account Id must greater than 0");
        return ResponseEntity.ok(incomeSourceService.createIncomeSource(name,accountId));
    }

    @PutMapping("/{incomeSourceId}")
    ResponseEntity<IncomeSourceDTO> updateIncomeSource(@PathVariable  int incomeSourceId, @RequestParam String newName) {
        return ResponseEntity.ok(incomeSourceService.updateIncomeSource(incomeSourceId,newName));
    }
    @PutMapping("/{incomeSourceId}/balance")
    ResponseEntity<IncomeSourceDTO> updateIncomeSourceBalance(@PathVariable  int incomeSourceId, @RequestParam int balance) {
        log.info("UPDATE INCOME SOURCE BALANCE RESOURCE");
        return ResponseEntity.ok(incomeSourceService.updateIncomeSourceBalance(incomeSourceId,balance));
    }

    @GetMapping("/incomeSourceDetail")
    public List<IncomeSourceDTO> findByIncomeSourceNameAndAccountId(@RequestParam String name,@PathVariable int accountId){

        //Throw JarsManagementException
        if (accountId <= 0) throw JarsManagementException.badRequest("WrongFormat","Account Id must greater than 0");

        return incomeSourceService.findByIncomeSourceNameAndAccountId(name,accountId);
    }


}
