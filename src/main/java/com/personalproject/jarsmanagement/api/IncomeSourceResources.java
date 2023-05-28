package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDTO;
import com.personalproject.jarsmanagement.service.IncomeSourceService;
import com.personalproject.jarsmanagement.service.mapper.IncomeSourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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


    @GetMapping("/incomeSourceDetail")
    public List<IncomeSourceDTO> findByIncomeSourceNameAndAccountId(@RequestParam String name,@PathVariable int accountId){

        //Throw JarsManagementException
        if (accountId <= 0) throw JarsManagementException.badRequest("WrongFormat","Account Id must greater than 0");

        return incomeSourceService.findByIncomeSourceNameAndAccountId(name,accountId);
    }


}
