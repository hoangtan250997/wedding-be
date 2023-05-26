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
@RequestMapping("/{userId}/income")
public class IncomeResources {
    private final IncomeService incomeService;

    @GetMapping("/incomesourcelist")
    public List<String>listIncomeSourceByUserId(@PathVariable int userId){
        return incomeService.listIncomeSourceByUserId(userId);
    }

    @PostMapping
    public Income createIncome(@RequestBody IncomeDTO incomeDTO,@PathVariable int userId){
        return incomeService.createIncome(incomeDTO,userId);
    }

    @GetMapping
    public List<IncomeDTO> findByIncomeSourceIdAndUserId(@RequestParam int incomeSourceId,@PathVariable int userId){

        //Throw Exception
        if (incomeSourceId <= 0) throw Exception.badRequest("WrongFormat","Income Source Id must greater than 0");
        if (userId <= 0) throw Exception.badRequest("WrongFormat","User Id must greater than 0");

        return incomeService.findByIncomeSourceIdAndUserId(incomeSourceId,userId);
    }

}
