package com.personalproject.jarsmanagement.service.DTO;

import com.personalproject.jarsmanagement.entity.JarType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AssignDTO {
    private Integer id;
    private Double amount;
    private LocalDate assignedTime;
    private int accountId;
    private int incomeSourceId;
    private int moneyJarId;
    private JarType jarType;

}
