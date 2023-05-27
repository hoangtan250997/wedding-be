package com.personalproject.jarsmanagement.service.factorymethod;

import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import lombok.AllArgsConstructor;

public class Give extends AbstractJar {
    private MoneyJar moneyJar;

    @Override
    public MoneyJar createJar() {
        MoneyJar moneyJar = new MoneyJar();
        moneyJar.setJarType(JarType.GIVE);
        moneyJar.setBalance((double) 0);
        moneyJar.setPercentage(0.05);
        return moneyJar;
    }
}
