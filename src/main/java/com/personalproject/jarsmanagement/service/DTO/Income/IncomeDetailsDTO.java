package com.personalproject.jarsmanagement.service.DTO.Income;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeDetailsDTO {

    //    private int id;
    private int accountId;
    private String incomeSourceName;
    private Double amount;
//    private LocalDate receivedTime;


}
