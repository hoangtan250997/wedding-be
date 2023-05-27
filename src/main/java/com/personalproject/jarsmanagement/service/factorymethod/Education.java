package com.personalproject.jarsmanagement.service.factorymethod;

import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import lombok.AllArgsConstructor;

public class Education extends AbstractJar {
    private MoneyJar moneyJar;

    @Override
    public MoneyJar createJar() {
        MoneyJar moneyJar = new MoneyJar();
        moneyJar.setJarType(JarType.EDUCATION);
        moneyJar.setBalance((double) 0);
        moneyJar.setPercentage(0.1);

        return moneyJar;
    }
}