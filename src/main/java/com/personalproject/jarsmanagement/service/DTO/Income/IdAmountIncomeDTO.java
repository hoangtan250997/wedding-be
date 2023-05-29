package com.personalproject.jarsmanagement.service.DTO.Income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdAmountIncomeDTO {

    private int accountId;
    private Double amount;

}
