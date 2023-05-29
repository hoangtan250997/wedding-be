package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.repository.MoneyJarRepository;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.factorymethod.AbstractJar;
import com.personalproject.jarsmanagement.service.factorymethod.JarsFactory;
import com.personalproject.jarsmanagement.service.mapper.JarTypeAttributeConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MoneyJarServiceImpl implements MoneyJarService {

    final private AccountRepository accountRepository;
    final private MoneyJarRepository moneyJarRepository;

    //This class to convert JarType types
    private JarTypeAttributeConverter jarTypeAttributeConverter = new JarTypeAttributeConverter();

    @Override
    public Double getBalance(int jarType, int accountId) {
        if (jarType > JarType.values().length) throw JarsManagementException.badRequest("NotFound", "JarTypeNotFound");
        return findByAccountIAndJarType(jarType, accountId).getBalance();
    }

    @Override
    public MoneyJar findByAccountIAndJarType(int accountId, int jarType) {
        if (jarType > JarType.values().length) throw JarsManagementException.badRequest("NotFound", "JarTypeNotFound");
        return moneyJarRepository.findByAccountIdAndJarType(accountId, jarTypeAttributeConverter.convertToEntityAttribute(jarType));
    }

    @Override
    public List<MoneyJar> createJars(int accountId) {
        log.info("Create 7 jars");

        List<MoneyJar> jars = new ArrayList<>();

        //Create 7 jars using Factory method
        for (int i = 0; i < 7; i++) {
            AbstractJar jar = JarsFactory.getJar(i + 1);
            MoneyJar moneyJar = jar.createJar();
            moneyJar.setAccount(accountRepository.findById(accountId).orElseThrow(JarsManagementException::AccountNotFound));
            moneyJarRepository.save(moneyJar);
            jars.add(moneyJarRepository.save(moneyJar));

        }
        return jars;
    }

    @Override
    public void increaseBalance(AssignDTO assignDTO) {
        MoneyJar moneyJar = findByAccountIAndJarType(assignDTO.getAccountId(), assignDTO.getMoneyJarId());
        moneyJar.setBalance(moneyJar.getBalance() + assignDTO.getAmount());
        moneyJarRepository.save(moneyJar);
    }

    @Override
    public void decreaseBalance(AssignDTO assignDTO) {
        MoneyJar moneyJar = findByAccountIAndJarType(assignDTO.getAccountId(), assignDTO.getMoneyJarId());
        moneyJar.setBalance(moneyJar.getBalance() - assignDTO.getAmount());
        moneyJarRepository.save(moneyJar);
    }


}
