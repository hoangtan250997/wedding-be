package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.service.IncomeSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{userId}/incomesource")
public class IncomeSourceResources {
    private final IncomeSourceService incomeSourceService;

    @GetMapping
    ResponseEntity<List<IncomeSource>> findAllIncomeSource(){
        return ResponseEntity.ok(incomeSourceService.findAllIncomeSource());
    }

    @PostMapping
    ResponseEntity<IncomeSource> createIncomeSource(@RequestParam String name, @PathVariable int userId){
        return ResponseEntity.ok(incomeSourceService.createIncomeSource(name,userId));
    }





}
