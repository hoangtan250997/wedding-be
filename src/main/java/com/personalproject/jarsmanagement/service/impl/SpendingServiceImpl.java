package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.repository.MoneyJarRepository;
import com.personalproject.jarsmanagement.repository.SpendingRepository;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.SpendingService;
import com.personalproject.jarsmanagement.service.mapper.SpendingMapper;
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
    public SpendingDTO createSpending(SpendingDTO spendingDTO) {

        Spending spending = new Spending();
        spending.setAmount(spendingDTO.getAmount());

        //Update date if user don't want to input
        if (spendingDTO.getSpendingTime() == null) {
            spending.setSpendingTime(LocalDate.now());
        } else spending.setSpendingTime(spendingDTO.getSpendingTime());

        spending.setPurpose(spendingDTO.getPurpose());
        spending.setMoneyJar(moneyJarRepository.findById(spendingDTO.getMoneyJarId()).get());
        spending.setAccount(accountRepository.findById(spendingDTO.getAccountId()).get());

        //Create AssignDTO for decreaseBalance MoneyJar
        AssignDTO assignDTO = new AssignDTO();
        assignDTO.setAmount(spending.getAmount());
        assignDTO.setAccountId(spending.getAccount().getId());
        assignDTO.setMoneyJarId(spending.getMoneyJar().getId());
        //decreaseBalance for moneyJar
        moneyJarService.decreaseBalance(assignDTO);

        return SpendingMapper.INSTANCE.mapToDto(spendingRepository.save(spending));
    }
}
