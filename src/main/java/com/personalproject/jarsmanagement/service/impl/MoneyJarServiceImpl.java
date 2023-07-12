package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.repository.MoneyJarRepository;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDTO;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.factorymethod.AbstractJar;
import com.personalproject.jarsmanagement.service.factorymethod.JarsFactory;
import com.personalproject.jarsmanagement.service.mapper.IncomeSourceMapper;
import com.personalproject.jarsmanagement.service.mapper.JarTypeAttributeConverter;
import com.personalproject.jarsmanagement.service.mapper.MoneyJarMapper;
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
    public Double showBalance(int jarType, int accountId) {
        return findByAccountIdAndJarType(jarType, accountId).getBalance();
    }

    @Override
    public MoneyJar findByAccountIdAndJarType(int accountId, int jarType) {
        log.info("FIND BY ACCOUNT ID AND JAR TYPE / MONEY JAR");
        return moneyJarRepository.findByAccountIdAndJarType(accountId, jarTypeAttributeConverter.convertToEntityAttribute(jarType));

    }

    @Override
    public List<MoneyJarDTO> findByAccountId(int accountId) {
        List<MoneyJar> moneyJarList = moneyJarRepository.findByAccount(accountRepository.findById(accountId).orElseThrow(JarsManagementException::AccountNotFound));
        return MoneyJarMapper.INSTANCE.mapToDtos(moneyJarList);
    }

    @Override
    public MoneyJarDTO updateJarBalance(int moneyJarId, double balance) {
        log.info("UPDATE JAR SOURCE BALANCE");
        MoneyJar moneyJar = moneyJarRepository.findById(moneyJarId).get();
        moneyJar.setBalance(balance);
        return MoneyJarMapper.INSTANCE.mapToDto(moneyJarRepository.save(moneyJar));
    }

    @Override
    public List<MoneyJar> createJars(int accountId) {
        log.info("CREATE 7 JARS");

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
        log.info("+ BALANCE MONEY JAR ");
        MoneyJar moneyJar = findByAccountIdAndJarType(assignDTO.getAccountId(), jarTypeAttributeConverter.convertToDatabaseColumn(assignDTO.getJarType()));


        moneyJar.setBalance(moneyJar.getBalance() + assignDTO.getAmount());
        log.info("SET BALANCE SUCCESSFUL ");

        moneyJarRepository.save(moneyJar);
        log.info("INCREASE MONEY JAR BALANCE SUCCESSFUL ");

    }

    @Override
    public void decreaseBalance(AssignDTO assignDTO) {
        log.info("- BALANCE / MONEY JAR ");
        MoneyJar moneyJar = findByAccountIdAndJarType(assignDTO.getAccountId(), jarTypeAttributeConverter.convertToDatabaseColumn(assignDTO.getJarType()));
        log.info("SET BALANCE SUCCESSFUL ");
        moneyJar.setBalance(moneyJar.getBalance() - assignDTO.getAmount());
        log.info("INCREASE MONEY JAR BALANCE SUCCESSFUL ");
        moneyJarRepository.save(moneyJar);
    }


}
