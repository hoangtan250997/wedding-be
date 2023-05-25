package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;

import java.util.List;

public interface IncomeService {
    Income createIncome(IncomeDTO incomeDTO,int userId);

    List<String> listIncomeSourceByUserId(int userId);

    List<Income> findByIncomeSourceIdAndUserId(int incomeSourceId, int userId);
}
