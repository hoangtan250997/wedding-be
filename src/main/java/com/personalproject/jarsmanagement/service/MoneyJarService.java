package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoneyJarService {
    List<MoneyJarDTO> createJars(int accountId);
    MoneyJarDTO updateJar(int accountId,double amount);


    MoneyJar findByAccountIAndJarType(int accountId, int jarType);
}
