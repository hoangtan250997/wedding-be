package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.entity.SpendingLimit;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.SpendingLimitRepository;
import com.personalproject.jarsmanagement.repository.SpendingRepository;
import com.personalproject.jarsmanagement.service.DTO.SpendingLimitDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.SpendingLimitService;
import com.personalproject.jarsmanagement.service.mapper.SpendingLimitMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpendingLimitServiceImpl implements SpendingLimitService {
    final private SpendingLimitRepository spendingLimitRepository;

    final private MoneyJarService moneyJarService;

    @Override
    public SpendingLimitDTO createSpendingLimit(SpendingLimitDTO spendingLimitDTO, int accountId, int jarType) {


            MoneyJar moneyJar = moneyJarService.findByAccountIAndJarType(accountId, jarType);

            SpendingLimit spendingLimit = new SpendingLimit();

            spendingLimit.setMoneyJar(moneyJar);
            spendingLimit.setExpirationDate(spendingLimitDTO.getExpirationDate());
            spendingLimit.setAmount(spendingLimitDTO.getAmount());

        return SpendingLimitMapper.INSTANCE.mapToDto(spendingLimitRepository.save(spendingLimit));
    }
}
