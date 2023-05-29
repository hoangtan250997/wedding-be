package com.personalproject.jarsmanagement.service.factorymethod;

import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import lombok.AllArgsConstructor;

public class FreeMoney extends AbstractJar {
    private MoneyJar moneyJar;

    @Override
    public MoneyJar createJar() {
        MoneyJar moneyJar = new MoneyJar();
        moneyJar.setJarType(JarType.FREE_MONEY);
        moneyJar.setBalance((double) 0);
        moneyJar.setPercentage(1.0);
        return moneyJar;
    }
}
