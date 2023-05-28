package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Assign;
import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.AssignRepository;
import com.personalproject.jarsmanagement.repository.IncomeRepository;
import com.personalproject.jarsmanagement.repository.IncomeSourceRepository;
import com.personalproject.jarsmanagement.service.AssignService;
import com.personalproject.jarsmanagement.service.DTO.AssignDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.IncomeSourceService;
import com.personalproject.jarsmanagement.service.MoneyJarService;
import com.personalproject.jarsmanagement.service.mapper.AssignMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

@Service
@RequiredArgsConstructor
public class AssignServiceImpl implements AssignService {
    final private MoneyJarService moneyJarService;
    final private AssignRepository assignRepository;
    final private IncomeSourceService incomeSourceService;
    final private IncomeSourceRepository incomeSourceRepository;

    @Override
    public List<AssignDTO> createAssign(int incomeSouceId, double amount) {
        List<Assign> assignList = new ArrayList<>();

        IncomeSource incomeSource = incomeSourceRepository.findById(incomeSouceId).orElseThrow(JarsManagementException::IncomeSourceNotFound);

        for (int i = 0; i < 6; i++) {
            Assign assign = new Assign();
            assign.setAmount(moneyJarService.findByAccountIAndJarType(incomeSource.getAccount().getId(), i + 1).getPercentage() * amount);

            assign.setIncomeSource(incomeSource);
            assign.setMoneyJar(moneyJarService.findByAccountIAndJarType(incomeSource.getAccount().getId(), i + 1));
            assignList.add(assignRepository.save(assign));

            //Create AssignDTO for update MoneyJar
            AssignDTO assignDTO = new AssignDTO();
            assignDTO.setAmount(assign.getAmount());
            assignDTO.setAccountId(assign.getIncomeSource().getAccount().getId());
            assignDTO.setMoneyJarId(assign.getMoneyJar().getId());
            //Automatically increase Balance for moneyJar
            moneyJarService.increaseBalance(assignDTO);
        }

        //Automatically decrease Balance for income Source
        incomeSourceService.decreaseBalance(incomeSouceId, amount);
        return AssignMapper.INSTANCE.mapToDtos(assignList);
    }
}
