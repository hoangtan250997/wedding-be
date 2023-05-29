package com.personalproject.jarsmanagement.service.DTO;

import com.personalproject.jarsmanagement.entity.JarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyJarDTO {
    private int id;

    private JarType jarType;

    private double balance;

    private double percentage;

    private int accountId;
}
