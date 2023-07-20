package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.DTO.Spending.JarDTO;
import com.personalproject.jarsmanagement.service.DTO.Spending.PurposeDTO;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;
import com.personalproject.jarsmanagement.service.SpendingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/spending")
public class SpendingResources {
    private final SpendingService spendingService;
    private final AccountService accountService;


    @PostMapping
    public ResponseEntity<SpendingDTO> createSpending(@RequestBody SpendingDTO spendingDTO, @RequestHeader("Authorization") String token) {
        int accountId = accountService.getAccountFromToken(token).getId();
        return ResponseEntity.ok(spendingService.createSpending(spendingDTO, accountId));
    }

    @GetMapping("/topJars")
    public ResponseEntity<List<JarDTO>> listJarsBetweenTwoDays(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(spendingService.listJarsBetweenTwoDays(start, end));
    }

    @GetMapping("/jarTop")
    public ResponseEntity<List<JarDTO>> listJarsByAccountIdBetweenTwoDays(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
                                                                          @RequestHeader("Authorization") String token, @RequestParam int topNumber) {
        return ResponseEntity.ok(spendingService.listJarsByAccountIdBetweenTwoDays(start, end, token, topNumber));
    }

    @GetMapping("/spending-list")
    public ResponseEntity<List<SpendingDTO>> getSpendingListByAccountIdBetweenTwoDays(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
                                                                                   @RequestHeader("Authorization") String token) {
        int accountId = accountService.getAccountFromToken(token).getId();
        return ResponseEntity.ok(spendingService.getSpendingListByAccountIdBetweenTwoDays(start, end, accountId));
    }
    @GetMapping("/purposeTop")
    public ResponseEntity<List<PurposeDTO>> listPurposeByAccountIdBetweenTwoDays(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
                                                                                 @RequestHeader("Authorization") String token) {
        int accountId = accountService.getAccountFromToken(token).getId();
        return ResponseEntity.ok(spendingService.listPurposeByAccountIdBetweenTwoDays(start, end, accountId));
    }

    @GetMapping("/purposeTopByMonth")
    public ResponseEntity<List<PurposeDTO>> listPurposeByAccountIdByMonthNumber(@RequestHeader("Authorization") String token, @RequestParam int monthNum) {
        int accountId = accountService.getAccountFromToken(token).getId();
        return ResponseEntity.ok(spendingService.listPurposeByAccountIdByMonthNumber(accountId, monthNum));
    }
}
