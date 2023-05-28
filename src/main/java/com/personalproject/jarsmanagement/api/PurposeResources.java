package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.entity.Purpose;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.PurposeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{accountId}/purpose")
public class PurposeResources {
    private final PurposeService purposeService;

    @GetMapping
    ResponseEntity<List<Purpose>> findAllIncomeSource(){
        return ResponseEntity.ok(purposeService.findAllPurpose());
    }

    @PostMapping
    ResponseEntity<Purpose> createPurpose(@RequestParam String name, @PathVariable int accountId){
        return ResponseEntity.ok(purposeService.createPurpose(name,accountId));
    }

}
