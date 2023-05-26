package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.exception.Exception;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{accountId}/income")
public class IncomeResources {
    private final IncomeService incomeService;

    @GetMapping("/incomesourcelist")
    public List<String>listIncomeSourceByAccountId(@PathVariable int accountId){
        return incomeService.listIncomeSourceByAccountId(accountId);
    }

    @PostMapping
    public Income createIncome(@RequestBody IncomeDTO incomeDTO,@PathVariable int accountId){
        return incomeService.createIncome(incomeDTO,accountId);
    }

    @GetMapping
    public List<IncomeDTO> findByIncomeSourceIdAndAccountId(@RequestParam int incomeSourceId,@PathVariable int accountId){

        //Throw Exception
        if (incomeSourceId <= 0) throw Exception.badRequest("WrongFormat","Income Source Id must greater than 0");
        if (accountId <= 0) throw Exception.badRequest("WrongFormat","Account Id must greater than 0");

        return incomeService.findByIncomeSourceIdAndAccountId(incomeSourceId,accountId);
    }

}
