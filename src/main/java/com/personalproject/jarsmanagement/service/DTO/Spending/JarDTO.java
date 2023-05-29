package com.personalproject.jarsmanagement.service.DTO.Spending;

import com.personalproject.jarsmanagement.entity.JarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JarDTO {

    private int accountId;
    private JarType jarType;
    private Double amount;


}
