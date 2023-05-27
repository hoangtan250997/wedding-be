package com.personalproject.jarsmanagement.service.factorymethod;

import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.Jars;

public class Play implements Jar {
    private Jars jar;

    @Override
    public Jars createjar() {
        jar.setJarType(JarType.PLAY);
        jar.setBalance((double) 0);
        jar.setPercentage(0.1);
        return jar;
    }
}
