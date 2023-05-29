package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{accountId}/spending")
public class SpendingResources {
    private final SpendingService spendingService;

    @PostMapping
    public ResponseEntity<SpendingDTO> createSpending(@RequestBody SpendingDTO spendingDTO){
        return ResponseEntity.ok(spendingService.createSpending(spendingDTO));
    }


}
