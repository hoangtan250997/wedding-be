package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.service.DTO.Spending.JarDTO;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{accountId}/spending")
public class SpendingResources {
    private final SpendingService spendingService;

    @PostMapping
    public ResponseEntity<SpendingDTO> createSpending(@RequestBody SpendingDTO spendingDTO, @PathVariable int accountId){
        return ResponseEntity.ok(spendingService.createSpending(spendingDTO,accountId));
    }
    @GetMapping("/topJars")
    public ResponseEntity<List<JarDTO>> listJarsBetweenTwoDays(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return ResponseEntity.ok(spendingService.listJarsBetweenTwoDays(start,end));
    }

@GetMapping("/jarTop")
    public ResponseEntity<List<JarDTO>> listJarsByAccountIdBetweenTwoDays(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate start,
                                                                          @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate end,
                                                                          @PathVariable int accountId, @RequestParam int topNumber){
        return ResponseEntity.ok(spendingService.listJarsByAccountIdBetweenTwoDays(start,end,accountId,topNumber));
}
}
