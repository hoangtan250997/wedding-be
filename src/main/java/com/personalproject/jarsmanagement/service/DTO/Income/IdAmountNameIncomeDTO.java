package com.personalproject.jarsmanagement.service.DTO.Income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdAmountNameIncomeDTO {

    private int accountId;
    private String incomeSourceName;
    private Double amount;

}
