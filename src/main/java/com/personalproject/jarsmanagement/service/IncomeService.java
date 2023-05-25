package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;

import java.util.List;

public interface IncomeService {
    Income createIncome(IncomeDTO incomeDTO);

    List<String> listIncomeSourceByUserId(int userId);
}
