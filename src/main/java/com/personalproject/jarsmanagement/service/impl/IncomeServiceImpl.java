package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.exception.Exception;
import com.personalproject.jarsmanagement.repository.IncomeRepository;
import com.personalproject.jarsmanagement.repository.IncomeSourceRepository;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.UserService;
import com.personalproject.jarsmanagement.service.mapper.IncomeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;
    private final IncomeSourceRepository incomeSourceRepository;
    private final UserService userService;
    private final IncomeMapper incomeMapper;

    @Override
    public Income createIncome(IncomeDTO incomeDTO,int userId) {
        Income income = new Income();
        income.setAmount(incomeDTO.getAmount());
        income.setIncomeSource(incomeSourceRepository.findById(incomeDTO.getIncomeSourceId()).get());
        income.setUser(userService.findById(userId));
        return incomeRepository.save(income);
    }

    @Override
    public List<String> listIncomeSourceByUserId(int userId) {
        return incomeRepository.listIncomeSourceByUserId(userId);
    }

    @Override
    public List<IncomeDTO> findByIncomeSourceIdAndUserId(int incomeSourceId, int userId) {

        return incomeMapper.mapToDtos(incomeRepository.findByIncomeSourceIdAndUserId(incomeSourceId,userId));
    }
}
