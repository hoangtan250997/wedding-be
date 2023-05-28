package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.repository.MoneyJarRepository;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.factorymethod.AbstractJar;
import com.personalproject.jarsmanagement.service.factorymethod.JarsFactory;
import com.personalproject.jarsmanagement.service.mapper.JarTypeAttributeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoneyJarServiceImpl implements MoneyJarService {

    final private AccountRepository accountRepository;
    final private MoneyJarRepository moneyJarRepository;
    private JarTypeAttributeConverter jarTypeAttributeConverter = new JarTypeAttributeConverter();

    @Override
    public List<MoneyJar> createJars(int accountId) {

        List<MoneyJar> jars = new ArrayList<>();
        System.out.println(accountId);

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
    public MoneyJarDTO updateJar(int accountId, double amount) {
        for (int i = 0; i < 7; i++) {

        }
        return null;
    }

    @Override
    public MoneyJar findByAccountIAndJarType(int accountId, int jarType) {
        return moneyJarRepository.findByAccountIAndJarType(accountId, jarTypeAttributeConverter.convertToEntityAttribute(jarType));
    }


}
