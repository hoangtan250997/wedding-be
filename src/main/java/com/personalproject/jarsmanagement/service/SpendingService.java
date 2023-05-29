package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;

public interface SpendingService {
    SpendingDTO createSpending(SpendingDTO spendingDTO, int accountId);
}
