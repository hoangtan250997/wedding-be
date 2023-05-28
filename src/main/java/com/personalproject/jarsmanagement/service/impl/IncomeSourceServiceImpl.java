package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.repository.IncomeRepository;
import com.personalproject.jarsmanagement.repository.IncomeSourceRepository;
import com.personalproject.jarsmanagement.repository.UserRepository;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDTO;
import com.personalproject.jarsmanagement.service.IncomeSourceService;
import com.personalproject.jarsmanagement.service.mapper.IncomeSourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeSourceServiceImpl implements IncomeSourceService {
    private final IncomeSourceRepository incomeSourceRepository;
    private final AccountRepository accountRepository;

    @Override
    public IncomeSource findIncomeSourceById(int id) {
        return incomeSourceRepository.findById(id).get();
    }

    @Override
    public List<IncomeSourceDTO> findByAccountId(int accountId) {

        return IncomeSourceMapper.INSTANCE.mapToDtos( incomeSourceRepository.findByAccount(accountRepository.findById(accountId).get()));
    }

    @Override
    public List<IncomeSource> findAllIncomeSource() {
        return incomeSourceRepository.findAll();
    }

    @Override
    public IncomeSource createIncomeSource(String name, int accountId) {

        List<String> incomeSourceStringList = incomeSourceRepository.findAll().stream()
                .map(IncomeSource::getName)
                .collect(Collectors.toList());

        IncomeSource incomeSource = new IncomeSource();
        incomeSource.setName(name);
        incomeSource.setBalance(0);
        incomeSource.setAccount(accountRepository.findById(accountId).get());
        incomeSourceRepository.save(incomeSource);

        return incomeSourceRepository.save(incomeSource);
    }

    @Override
    public List<IncomeSource> findByNameAndAccountId(String name, int accountId) {
        return incomeSourceRepository.findByNameAndAccountId(name, accountId);
    }

    @Override
    public void increaseBalance(int incomeSourceId, double amount) {
        IncomeSource incomeSource = incomeSourceRepository.findById(incomeSourceId).get();
        incomeSource.setBalance(incomeSource.getBalance() + amount);
        incomeSourceRepository.save(incomeSource);
    }

    @Override
    public void decreaseBalance(int incomeSourceId, double amount) {
        IncomeSource incomeSource = incomeSourceRepository.findById(incomeSourceId).get();
        incomeSource.setBalance(incomeSource.getBalance() - amount);
        incomeSourceRepository.save(incomeSource);
    }

}
