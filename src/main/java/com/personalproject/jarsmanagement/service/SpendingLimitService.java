package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.SpendingLimit;
import com.personalproject.jarsmanagement.service.DTO.SpendingLimitDTO;

public interface SpendingLimitService {
    SpendingLimitDTO createSpendingLimit(SpendingLimitDTO spendingLimitDTO,int accountId, int jarType);
}
