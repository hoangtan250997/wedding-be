package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.service.DTO.MoneyJarDTO;

import java.util.List;

public interface MoneyJarService {
    List<MoneyJarDTO> createJars(int accountId);
    MoneyJarDTO updateJar(int accountId,double amount);
}
