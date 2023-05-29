package com.personalproject.jarsmanagement.api;

import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.service.AssignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{accountId}/assign")
public class AssignResources {
    private final AssignService assignService;

    @PostMapping
    public ResponseEntity<Void> createAssigns(@RequestParam int incomeSourceId,@RequestParam double amount){
        if (amount<=0) throw JarsManagementException.badRequest("WrongFormat","amount must be greater than 0");
        assignService.createAssign(incomeSourceId,amount);
        return ResponseEntity.noContent().build();
    }

}
