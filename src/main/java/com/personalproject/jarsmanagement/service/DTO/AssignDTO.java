package com.personalproject.jarsmanagement.service.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AssignDTO {
    private Double amount;
    private LocalDate assignedTime;
    private int accountId;
    private int incomeSourceId;

    private int MoneyJarId;

}
