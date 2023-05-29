package com.personalproject.jarsmanagement.service.DTO.Spending;

import com.personalproject.jarsmanagement.entity.JarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurposeDTO {
    private int accountId;
    private String purpose;
    private Double amount;


}
