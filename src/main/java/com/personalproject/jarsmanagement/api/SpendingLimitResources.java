package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.service.DTO.SpendingLimitDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.SpendingLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{accountId}/moneyJar/{jarType}/limit")
public class SpendingLimitResources {
    private final SpendingLimitService spendingLimitService;

    @PostMapping
    public ResponseEntity<SpendingLimitDTO> createSpendingLimit(@RequestBody SpendingLimitDTO spendingLimitDTO, @PathVariable int accountId, @PathVariable int jarType){
        return ResponseEntity.ok(spendingLimitService.createSpendingLimit(spendingLimitDTO,accountId,jarType));
    }

}
