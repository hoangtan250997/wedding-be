package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.MoneyJar;

import java.util.List;

public interface JarsService {
    List<MoneyJar> createJars(int accountId);
}
