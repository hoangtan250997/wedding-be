package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.service.DTO.Spending.JarDTO;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;

import java.time.LocalDate;
import java.util.List;

public interface SpendingService {
    SpendingDTO createSpending(SpendingDTO spendingDTO, int accountId);

    List<JarDTO> listJarsBetweenTwoDays(LocalDate start, LocalDate end);

    List<JarDTO> listJarsByAccountIdBetweenTwoDays(LocalDate start, LocalDate end, int accountId, int topnumber);

}
