package com.personalproject.jarsmanagement.service.factorymethod;

import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.Jars;

public class LongTermSavings implements Jar {
    private Jars jar;

    @Override
    public Jars createjar() {
        jar.setJarType(JarType.lONG_TERM_SAVINGS);
        jar.setBalance((double) 0);
        jar.setPercentage(0.1);
        return jar;
    }
}
