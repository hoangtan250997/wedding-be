package com.personalproject.jarsmanagement.service.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeDTO {

    private int id;
    private Double amount;
    private LocalDate receivedTime;
    private int incomeSourceId;
    private String incomeSourceName;
}
