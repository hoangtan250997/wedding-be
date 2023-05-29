package com.personalproject.jarsmanagement.service.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AssignDTO {
    private int id;
    private double amount;
    private LocalDate assignedTime;
    private int accountId;
    private int incomeSourceId;
    private int moneyJarId;

}
