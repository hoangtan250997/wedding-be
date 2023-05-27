package com.personalproject.jarsmanagement.service.factorymethod;

import com.personalproject.jarsmanagement.service.mapper.JarTypeAttributeConverter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@RequiredArgsConstructor
public class JarFactory {
    public static final Jar getJar(int jarNumber) {
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
