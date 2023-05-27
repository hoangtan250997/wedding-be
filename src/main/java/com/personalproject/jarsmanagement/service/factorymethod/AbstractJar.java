package com.personalproject.jarsmanagement.service.factorymethod;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import lombok.Data;
import lombok.NoArgsConstructor;

public abstract class AbstractJar {
    private JarType jarType;

    private Double balance;

    private double percentage;

    private Account account;
    public abstract MoneyJar createJar();

}
