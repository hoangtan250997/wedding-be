package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.repository.MoneyJarRepository;
import com.personalproject.jarsmanagement.repository.SpendingRepository;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.Spending.JarDTO;
import com.personalproject.jarsmanagement.service.DTO.Spending.PurposeDTO;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.SpendingService;
import com.personalproject.jarsmanagement.service.mapper.SpendingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpendingServiceImpl implements SpendingService {
    final private SpendingRepository spendingRepository;
    final private MoneyJarRepository moneyJarRepository;
    final private AccountRepository accountRepository;

    final private MoneyJarService moneyJarService;

    @Override
    public SpendingDTO createSpending(SpendingDTO spendingDTO, int accountId) {
        log.info("CREATE SPENDING");

        Spending spending = new Spending();
        spending.setAmount(spendingDTO.getAmount());

        //Update date if user don't want to input
        if (spendingDTO.getSpendingTime() == null) {
            spending.setSpendingTime(LocalDate.now());
        } else spending.setSpendingTime(spendingDTO.getSpendingTime());

        spending.setPurpose(spendingDTO.getPurpose());
        spending.setMoneyJar(moneyJarRepository.findById(spendingDTO.getMoneyJarId()).get());
        spending.setAccount(accountRepository.findById(accountId).get());

        //Create AssignDTO for decreaseBalance MoneyJar
        AssignDTO assignDTO = new AssignDTO();
        assignDTO.setAmount(spending.getAmount());
        assignDTO.setAccountId(accountId);
        assignDTO.setMoneyJarId(spending.getMoneyJar().getId());
        assignDTO.setJarType(spending.getMoneyJar().getJarType());

        //decreaseBalance for moneyJar
        moneyJarService.decreaseBalance(assignDTO);

        return SpendingMapper.INSTANCE.mapToDto(spendingRepository.save(spending));
    }

    @Override
    public List<JarDTO> listJarsBetweenTwoDays(LocalDate start, LocalDate end) {
        return spendingRepository.listJarsBetweenTwoDays(start,end);
    }

    @Override
    public List<JarDTO> listJarsByAccountIdBetweenTwoDays(LocalDate start, LocalDate end, int accountId, int topNumber) {
        return spendingRepository.listJarsByAccountIdBetweenTwoDays(start,end,accountId).stream()
                .limit(topNumber)
                .collect(Collectors.toList());
    }

    @Override
    public List<PurposeDTO> listPurposeByAccountIdBetweenTwoDays(LocalDate start, LocalDate end, int accountId) {
        return spendingRepository.listPurposeByAccountIdBetweenTwoDays(start,end,accountId);
    }

    @Override
    public List<PurposeDTO> listPurposeByAccountIdByMonthNumber(int accountId, int monthNum) {
        return spendingRepository.listPurposeByAccountIdByMonthNumber(accountId,monthNum);
    }

}
