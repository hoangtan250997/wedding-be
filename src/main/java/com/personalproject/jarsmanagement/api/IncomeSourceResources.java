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
    ResponseEntity<List<IncomeSource>> findAllIncomeSource(){
        return ResponseEntity.ok(incomeSourceService.findAllIncomeSource());
    }
    @GetMapping("/list")
    ResponseEntity<List<IncomeSourceDTO>> findByAccountId(@PathVariable int accountId){
        return ResponseEntity.ok(incomeSourceService.findByAccountId(accountId));
    }
    @PostMapping
    ResponseEntity<IncomeSourceDTO> createIncomeSource(@RequestParam String name, @PathVariable int accountId){
        return ResponseEntity.ok(IncomeSourceMapper.INSTANCE.mapToDto(incomeSourceService.createIncomeSource(name,accountId)));
    }


    @GetMapping("/incomeSourceDetail")
    public List<IncomeSource> findByNameAndAccountId(@RequestParam String name,@PathVariable int accountId){

        //Throw JarsManagementException
        if (accountId <= 0) throw JarsManagementException.badRequest("WrongFormat","Account Id must greater than 0");

        return incomeSourceService.findByNameAndAccountId(name,accountId);
    }


}
