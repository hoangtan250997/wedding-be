package com.personalproject.jarsmanagement.service.factorymethod;

import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import lombok.AllArgsConstructor;


public class Necessities extends AbstractJar {

    @Override
    public MoneyJar createJar() {
         MoneyJar moneyJar = new MoneyJar();
        moneyJar.setJarType(JarType.NECESSITIES);
        moneyJar.setBalance((double) 0);
        moneyJar.setPercentage(0.55);
        return moneyJar;
    }
}
