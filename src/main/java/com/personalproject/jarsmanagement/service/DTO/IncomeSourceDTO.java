package com.personalproject.jarsmanagement.service.DTO;

import lombok.Data;

@Data
public class IncomeSourceDTO {
    private int id;
    private String name;
    private Double balance;
    private int accountId;
    private String accountName;


}
