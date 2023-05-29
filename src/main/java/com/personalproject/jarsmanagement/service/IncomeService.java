package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.service.DTO.Income.IdAmountIncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.idAmountNameIncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.IncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.IncomeDetailsDTO;

import java.time.LocalDate;
import java.util.List;

public interface IncomeService {
    Income findById(int id);

    List<IncomeDetailsDTO> findByReceivedTimeBetween(LocalDate start, LocalDate end);

    IncomeDTO createIncome(IncomeDTO incomeDTO, int accountId);

    List<idAmountNameIncomeDTO> listIdAmountNameIncome(LocalDate start, LocalDate end);

    List<IdAmountIncomeDTO> listIdAmountIncomeDTO(LocalDate start, LocalDate end);

    List<idAmountNameIncomeDTO> listIdAmountNameIncomeByAccountId(LocalDate start, LocalDate end, int accountId);

    List<IdAmountIncomeDTO> listIdAmountIncomeDTOByAccountId(LocalDate start, LocalDate end, int accountId);


}
