package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{accountId}/moneyjar")
public class MoneyJarResources {
    private final MoneyJarService moneyJarService;
@GetMapping
    ResponseEntity<List<MoneyJarDTO>> createJar(@PathVariable int accountId){

    return ResponseEntity.ok(moneyJarService.createJars(accountId));
}
}
