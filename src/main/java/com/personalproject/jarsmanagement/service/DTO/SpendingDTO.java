package com.personalproject.jarsmanagement.service.DTO;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpendingDTO {

    private Integer id;

    private Double amount;
    private LocalDate spendingTime;

    private String purpose;


    private int accountId;

    private int moneyJarId;
}
