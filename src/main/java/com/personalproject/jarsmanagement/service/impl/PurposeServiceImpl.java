package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.entity.Purpose;
import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.repository.PurposeRepository;
import com.personalproject.jarsmanagement.repository.SpendingRepository;
import com.personalproject.jarsmanagement.service.PurposeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurposeServiceImpl implements PurposeService {
    final private PurposeRepository purposeRepository;
    final private AccountRepository accountRepository;

    final private SpendingRepository spendingRepository;
    @Override
    public Purpose findPurposeById(int id) {
        return purposeRepository.findById(id).get();
    }

    @Override
    public List<Purpose> findAllPurpose() {
        return purposeRepository.findAll();
    }

    @Override
    public Purpose createPurpose(String name, int accountId) {
        List<String> purposeStringList = purposeRepository.findAll().stream()
                .map(Purpose::getName)
                .collect(Collectors.toList());

        Spending spending = new Spending();
        spending.setAmount((double) 0);

//
//        if (purposeStringList.contains(name)) {
//            spending.setAccount(accountRepository.findById(accountId).get());
//            spendingRepository.save(spending);
//        } else {
            Purpose purpose = new Purpose();
            purpose.setName(name);
            purposeRepository.save(purpose);
//
//            spending.setPurpose(purpose);
//            spending.setAccount(accountRepository.findById(accountId).get());
//            spendingRepository.save(spending);
//        }
        return purposeRepository.findByName(name);
    }

}
