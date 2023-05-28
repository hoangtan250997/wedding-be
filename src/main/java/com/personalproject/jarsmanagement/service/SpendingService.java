package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;

public interface SpendingService {
    Spending createSpending(SpendingDTO spendingDTO);
}
