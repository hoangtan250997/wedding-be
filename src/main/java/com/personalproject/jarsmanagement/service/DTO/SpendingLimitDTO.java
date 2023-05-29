package com.personalproject.jarsmanagement.service.DTO;

import com.personalproject.jarsmanagement.entity.MoneyJar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpendingLimitDTO {

    private int id;
    private double amount;
    private LocalDate createdDate;
    private LocalDate expirationDate;
    private int moneyJarId;


}
