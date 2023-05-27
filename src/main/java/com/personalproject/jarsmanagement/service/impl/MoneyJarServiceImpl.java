package com.personalproject.jarsmanagement.service.impl;

//import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import com.personalproject.jarsmanagement.service.JarsService;
import com.personalproject.jarsmanagement.service.factorymethod.AbstractJar;
import com.personalproject.jarsmanagement.service.factorymethod.Jars;
import com.personalproject.jarsmanagement.service.factorymethod.JarsFactory;
import com.personalproject.jarsmanagement.service.mapper.JarTypeAttributeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JarsServiceImpl implements JarsService {
    final private JarTypeAttributeConverter jarTypeAttributeConverter;
    @Override
    public List<MoneyJar> createJars(int accountId) {
        List<MoneyJar> jars = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            AbstractJar jar = JarsFactory.getJar(i+1);

        }
        return null;
    }
}
