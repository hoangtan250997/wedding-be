package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/income")
public class IncomeResources {
    private final IncomeService incomeService;

//    @GetMapping("/incomesourcelist/{userId}")
//    public List<String>listIncomeSourceByUserId(@PathVariable int userId){
//        return incomeService.listIncomeSourceByUserId(userId);
//    }

    @PostMapping
    public Income createIncome(@RequestBody IncomeDTO incomeDTO){
        return incomeService.createIncome(incomeDTO);
    }

}
