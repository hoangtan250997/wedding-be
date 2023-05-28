package com.personalproject.jarsmanagement.service.DTO;

import lombok.Data;

@Data
public class IncomeDTO {

    private int id;
    private Double amount;
//    private String incomeSourceName;

    private int incomeSourceId;
}
