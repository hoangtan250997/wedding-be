package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.service.DTO.Cau2;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;

import java.time.LocalDate;
import java.util.List;

public interface IncomeService {
    Income findById(int id);
    List<Income> findByReceivedTimeBetween(LocalDate start, LocalDate end);
    IncomeDTO createIncome(IncomeDTO incomeDTO, int accountId);

    Double totalIncomeBetweenTwoDay(LocalDate start, LocalDate end);
    List<Cau2> cau2(LocalDate start, LocalDate end);

}
