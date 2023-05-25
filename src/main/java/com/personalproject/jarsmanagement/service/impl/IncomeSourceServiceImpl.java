package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.repository.IncomeRepository;
import com.personalproject.jarsmanagement.repository.IncomeSourceRepository;
import com.personalproject.jarsmanagement.repository.UserRepository;
import com.personalproject.jarsmanagement.service.IncomeSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeSourceServiceImpl implements IncomeSourceService {
    private final IncomeSourceRepository incomeSourceRepository;
    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;

    @Override
    public IncomeSource findIncomeSourceById(int id) {
        return incomeSourceRepository.findById(id).get();
    }

    @Override
    public List<IncomeSource> findAllIncomeSource() {
        return incomeSourceRepository.findAll();
    }

    @Override
    public IncomeSource createIncomeSource(String name,int userId) {

        IncomeSource incomeSource = new IncomeSource();
        incomeSource.setName(name);
        incomeSourceRepository.save(incomeSource);

        Income income = new Income();
        income.setAmount((double)0);
        income.setIncomeSource(incomeSource);
        income.setUser(userRepository.findById(userId).get());
        incomeRepository.save(income);

        return incomeSourceRepository.findByName(name);
    }

}
