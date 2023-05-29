package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.IncomeRepository;
import com.personalproject.jarsmanagement.repository.IncomeSourceRepository;
import com.personalproject.jarsmanagement.service.AccountService;
import com.personalproject.jarsmanagement.service.AssignService;
import com.personalproject.jarsmanagement.service.DTO.Cau2;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.IncomeSourceService;
import com.personalproject.jarsmanagement.service.mapper.IncomeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.jar.JarException;

@Service
@Slf4j
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepository incomeRepository;
    private final IncomeSourceRepository incomeSourceRepository;

    private final IncomeSourceService incomeSourceService;


    @Override
    public Income findById(int id) {
        return incomeRepository.findById(id).orElseThrow(JarsManagementException::IncomeNotFound);
    }
    @Override
    public IncomeDTO createIncome(IncomeDTO incomeDTO, int accountId) {

        Income income = new Income();
        income.setAmount(incomeDTO.getAmount());
        income.setIncomeSource(incomeSourceRepository.findById(incomeDTO.getIncomeSourceId()).get());

        //Automatically increase Jar Balance when an income is created
        log.info("Automatically call increaseBalance for MoneyJar");
        incomeSourceService.increaseBalance(income.getIncomeSource().getId(), income.getAmount());

        return IncomeMapper.INSTANCE.mapToDto(incomeRepository.save(income));
    }

    @Override
    public Double totalIncomeBetweenTwoDay(LocalDate start, LocalDate end) {
        Double total = findByReceivedTimeBetween(start,end).stream().mapToDouble(Income::getAmount).sum();
        return total;

    }

    @Override
    public List<Income> findByReceivedTimeBetween(LocalDate start, LocalDate end) {
        return incomeRepository.findByReceivedTimeBetween(start,end);
    }

    @Override
    public List<Cau2> cau2(LocalDate start, LocalDate end) {
        return incomeRepository.cau2(start,end);
    }



}
