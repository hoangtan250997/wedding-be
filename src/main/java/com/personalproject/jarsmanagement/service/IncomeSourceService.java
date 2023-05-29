package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDTO;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDetailDTO;

import java.time.LocalDate;
import java.util.List;

public interface IncomeSourceService {
//    List<IncomeSourceDetailDTO> listIncomeSourceBetweenTwoDay(LocalDate start, LocalDate end);

    IncomeSource findIncomeSourceById(int id);

    List<IncomeSourceDTO> findIncomeSourceByAccountId(int accountId);

    List<IncomeSourceDTO> findAllIncomeSource();

    List<IncomeSourceDTO> findByIncomeSourceNameAndAccountId(String name, int accountId);

    IncomeSourceDTO createIncomeSource(String name, int accountId);

    IncomeSourceDTO updateIncomeSource(int incomeSourceId, String newName);

    IncomeSourceDTO updateIncomeSourceBalance(int incomeSourceId, double balance);


    void increaseBalance(int incomeSourceId, double amount);

    void decreaseBalance(int incomeSourceId, double amount);

}
