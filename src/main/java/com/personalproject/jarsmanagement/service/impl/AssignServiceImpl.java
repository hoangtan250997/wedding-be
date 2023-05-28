package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Assign;
import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.repository.AssignRepository;
import com.personalproject.jarsmanagement.repository.IncomeRepository;
import com.personalproject.jarsmanagement.service.AssignService;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignServiceImpl implements AssignService {
final private MoneyJarService moneyJarService;
final private AssignRepository assignRepository;
final private IncomeRepository incomeRepository;
    @Override
    public List<Assign> createAssign(int incomeId) {
        List<Assign> assignList = new ArrayList<>();

        Income income = incomeRepository.findById(incomeId).get();


        Double amount = income.getAmount();

        for (int i = 0; i < 6; i++) {
            Assign assign = new Assign();
            assign.setAmount(moneyJarService.findByAccountIAndJarType(income.getAccount().getId(),i+1).getPercentage()*amount);
            assign.setIncome(income);
            assign.setMoneyJar(moneyJarService.findByAccountIAndJarType(income.getAccount().getId(),i+1));
            assignList.add(assignRepository.save(assign));
        }
        return assignList;
    }
}
