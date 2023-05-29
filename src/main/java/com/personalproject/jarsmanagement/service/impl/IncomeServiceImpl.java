package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.IncomeRepository;
import com.personalproject.jarsmanagement.repository.IncomeSourceRepository;
import com.personalproject.jarsmanagement.service.DTO.Income.IdAmountIncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.idAmountNameIncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.IncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.IncomeDetailsDTO;
import com.personalproject.jarsmanagement.service.IncomeService;
import com.personalproject.jarsmanagement.service.IncomeSourceService;
import com.personalproject.jarsmanagement.service.mapper.IncomeDetailsMapper;
import com.personalproject.jarsmanagement.service.mapper.IncomeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<IncomeDetailsDTO> findByReceivedTimeBetween(LocalDate start, LocalDate end) {
        return IncomeDetailsMapper.INSTANCE.mapToDtos(incomeRepository.findByReceivedTimeBetween(start, end));
    }

    @Override
    public List<IdAmountIncomeDTO> listIdAmountIncomeDTO(LocalDate start, LocalDate end) {
        return incomeRepository.listIdAmountIncomeDTO(start, end);
    }

    @Override
    public List<idAmountNameIncomeDTO> listIdAmountNameIncome(LocalDate start, LocalDate end) {
        return incomeRepository.listIdAmountNameIncome(start, end);
    }

    @Override
    public List<IdAmountIncomeDTO> listIdAmountIncomeDTOByAccountId(LocalDate start, LocalDate end, int accountId) {
        return incomeRepository.listIdAmountIncomeDTO(start, end).stream()
                .filter(i -> i.getAccountId() == accountId)
                .collect(Collectors.toList());
    }

    @Override
    public List<idAmountNameIncomeDTO> listIdAmountNameIncomeByAccountId(LocalDate start, LocalDate end, int accountId) {
        return incomeRepository.listIdAmountNameIncome(start, end).stream()
                .filter(i -> i.getAccountId() == accountId)
                .collect(Collectors.toList());

    }
}
