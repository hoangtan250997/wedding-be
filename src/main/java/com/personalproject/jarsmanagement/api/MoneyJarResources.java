package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.mapper.MoneyJarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{accountId}/moneyJar")
public class MoneyJarResources {
    private final MoneyJarService moneyJarService;

    @GetMapping
    ResponseEntity<List<MoneyJarDTO>> createJar(@PathVariable int accountId) {

        return ResponseEntity.ok(MoneyJarMapper.INSTANCE.mapToDtos(moneyJarService.createJars(accountId)));
    }

    @GetMapping("/specifiedJar")
    ResponseEntity<MoneyJarDTO> findByAccountIAndJarType(@PathVariable int accountId, @RequestParam int jarType) {
        return ResponseEntity.ok(MoneyJarMapper.INSTANCE.mapToDto(moneyJarService.findByAccountIAndJarType(accountId, jarType)));
//    return ResponseEntity.ok(moneyJarService.findByAccountIAndJarType(accountId,jarType));
    }

    @GetMapping("/{jarType}/balance")
    ResponseEntity<Double> getBalance(@PathVariable int accountId, @PathVariable int jarType) {
        return ResponseEntity.ok(moneyJarService.getBalance(jarType, accountId));
    }
}
