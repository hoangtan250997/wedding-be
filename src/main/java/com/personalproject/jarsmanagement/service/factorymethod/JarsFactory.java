package com.personalproject.jarsmanagement.service.factorymethod;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


public class JarsFactory {
    public static final AbstractJar getJar(int jarNumber) {
        switch (jarNumber) {
            case 1:
                return new Necessities();
            case 2:
                return new FinancialFreedom();
            case 3:
                return new LongTermSavings();
            case 4:
                return new Education();
            case 5:
                return new Play();
            case 6:
                return new Give();
            case 7:
                return new FreeMoney();
            default: throw new IllegalArgumentException("This jar type is unsupported");
        }

    }
}
