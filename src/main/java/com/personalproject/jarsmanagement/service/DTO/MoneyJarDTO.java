package com.personalproject.jarsmanagement.service.DTO;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.entity.JarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JarDTO {

    private Integer id;

//    private JarType jarType;

//    private Double balance;

    private double percentage;

//    private Account account;
}
