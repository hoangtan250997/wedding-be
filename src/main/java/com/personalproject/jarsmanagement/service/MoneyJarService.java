package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDTO;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;

import java.util.List;

public interface MoneyJarService {
    List<MoneyJar> createJars(int accountId);

    void increaseBalance(AssignDTO assignDTO);

    void decreaseBalance(AssignDTO assignDTO);

    Double showBalance(int jarType, int acountId);

    MoneyJar findByAccountIdAndJarType(int accountId, int jarType);

    List<MoneyJarDTO> findByAccountId(int account);

    MoneyJarDTO updateJarBalance(int moneyJarId, double balance);
}
