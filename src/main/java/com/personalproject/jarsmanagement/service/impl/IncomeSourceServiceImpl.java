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
import java.util.stream.Collectors;

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
    public IncomeSource createIncomeSource(String name, int userId) {

        List<String> incomeSourceStringList = incomeSourceRepository.findAll().stream()
                .map(IncomeSource::getName)
                .collect(Collectors.toList());

        Income income = new Income();
        income.setAmount((double) 0);

        if (incomeSourceStringList.contains(name)) {
            income.setIncomeSource(incomeSourceRepository.findByName(name));
            income.setUser(userRepository.findById(userId).get());
            incomeRepository.save(income);
        } else {
            IncomeSource incomeSource = new IncomeSource();
            incomeSource.setName(name);
            incomeSourceRepository.save(incomeSource);

            income.setIncomeSource(incomeSource);
            income.setUser(userRepository.findById(userId).get());
            incomeRepository.save(income);
        }
        return incomeSourceRepository.findByName(name);
    }

}
