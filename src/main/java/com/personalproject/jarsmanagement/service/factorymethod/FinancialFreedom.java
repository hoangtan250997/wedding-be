package com.personalproject.jarsmanagement.service.factorymethod;

import com.personalproject.jarsmanagement.entity.JarPercentage;
import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.Jars;

public class Necessities implements Jar {
    private Jars jar;

    @Override
    public Jars createjar() {
        jar.setJarType(JarType.NECESSITIES);
        jar.setBalance((double) 0);
        jar.setPercentage(0.55);
        return jar;
    }
}
