package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.repository.IncomeRepository;
import com.personalproject.jarsmanagement.repository.IncomeSourceRepository;
import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.AssignService;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.IncomeSourceService;
import com.personalproject.jarsmanagement.service.mapper.IncomeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;
    private final IncomeSourceRepository incomeSourceRepository;
    private final IncomeSourceService incomeSourceService;
    private final AccountService accountService;
    private final IncomeMapper incomeMapper;

    private final AssignService assignService;

    @Override
    public Income createIncome(IncomeDTO incomeDTO, int accountId) {
        Income income = new Income();
        income.setAmount(incomeDTO.getAmount());
        income.setIncomeSource(incomeSourceRepository.findByNameAndAccountId(incomeDTO.getIncomeSourceName(), accountId).get(0));

        incomeSourceService.increaseBalance(income.getIncomeSource().getId(), income.getAmount());
        return incomeRepository.save(income);
    }

//    @Override
//    public List<String> listIncomeSourceByAccountId(int accountId) {
//        return incomeRepository.listIncomeSourceByAccountId(accountId);
//    }
//
//    @Override
//    public List<IncomeDTO> findByIncomeSourceIdAndAccountId(int incomeSourceId, int accountId) {
//
//        return incomeMapper.mapToDtos(incomeRepository.findByIncomeSourceIdAndAccountId(incomeSourceId,accountId));
//    }

    @Override
    public Income findById(int id) {
        return incomeRepository.findById(id).get();
    }
}
