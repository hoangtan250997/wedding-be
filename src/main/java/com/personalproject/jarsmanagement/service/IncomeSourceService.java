package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.IncomeSource;

import java.util.List;

public interface IncomeSourceService {
    IncomeSource findIncomeSourceById(int id);

    List<IncomeSource> findAllIncomeSource();

    IncomeSource createIncomeSource(String name, int userId);


}
