package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.repository.MoneyJarRepository;
import com.personalproject.jarsmanagement.repository.SpendingRepository;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class SpendingServiceImpl implements SpendingService {
    final private SpendingRepository spendingRepository;
    final private MoneyJarRepository moneyJarRepository;
    final private AccountRepository accountRepository;

    final private MoneyJarService moneyJarService;
    @Override
    public Spending createSpending(@NotNull SpendingDTO spendingDTO) {
        Spending spending = new Spending();

        spending.setAmount(spendingDTO.getAmount());

        if (spendingDTO.getSpendingTime() == null) {
            spending.setSpendingTime(LocalDate.now());
        } else spending.setSpendingTime(spendingDTO.getSpendingTime());

        spending.setPurpose(spendingDTO.getPurpose());

        spending.setMoneyJar(moneyJarRepository.findById(spendingDTO.getMoneyJarId()).get());
        spending.setAccount(accountRepository.findById(spendingDTO.getAccountId()).get());

        //Create AssignDTO for update MoneyJar
        AssignDTO assignDTO = new AssignDTO();
        assignDTO.setAmount(spending.getAmount());
        assignDTO.setAccountId(spending.getAccount().getId());
        assignDTO.setMoneyJarId(spending.getMoneyJar().getId());
        moneyJarService.decreaseBalance(assignDTO);
        return spendingRepository.save(spending);
    }
}
