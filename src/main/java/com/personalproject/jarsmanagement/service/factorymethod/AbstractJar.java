package com.personalproject.jarsmanagement.service.factorymethod;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.service.mapper.JarTypeAttributeConverter;

import javax.persistence.Convert;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public abstract class AbstractJar {
    private JarType jarType;

    private Double balance;

    private double percentage;

    private int accountId;
    abstract MoneyJar createJar();

}
