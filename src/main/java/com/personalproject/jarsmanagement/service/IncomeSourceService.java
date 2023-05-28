package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDTO;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDetailDTO;

import java.time.LocalDate;
import java.util.List;

public interface IncomeSourceService {
//    List<IncomeSourceDetailDTO> listIncomeSourceBetweenTwoDay(LocalDate start, LocalDate end);

    IncomeSource findIncomeSourceById(int id);

    List<IncomeSourceDTO> findByAccountId(int accountId);

    List<IncomeSource> findAllIncomeSource();

    IncomeSource createIncomeSource(String name, int accountId);

    List<IncomeSource> findByNameAndAccountId(String name, int accountId);

    void increaseBalance(int incomeSourceId,double amount);

    void decreaseBalance(int incomeSourceId,double amount);

}
