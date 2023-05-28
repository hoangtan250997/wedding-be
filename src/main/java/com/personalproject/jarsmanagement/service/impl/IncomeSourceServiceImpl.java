package com.personalproject.jarsmanagement.service.impl;

import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.exception.JarsManagementException;
import com.personalproject.jarsmanagement.repository.AccountRepository;
import com.personalproject.jarsmanagement.repository.IncomeSourceRepository;
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
        return incomeSourceRepository.findById(id).orElseThrow(JarsManagementException::IncomeSourceNotFound);
    }

    @Override
    public List<IncomeSourceDTO> findIncomeSourceByAccountId(int accountId) {
        return IncomeSourceMapper.INSTANCE.mapToDtos(
                incomeSourceRepository
                        .findByAccount(accountRepository.findById(accountId).orElseThrow(JarsManagementException::AccountNotFound)));
    }

    @Override
    public List<IncomeSourceDTO> findAllIncomeSource() {
           return IncomeSourceMapper.INSTANCE.mapToDtos(incomeSourceRepository.findAll());
    }

    @Override
    public IncomeSourceDTO createIncomeSource(String name, int accountId) {

        IncomeSource incomeSource = new IncomeSource();
        incomeSource.setName(name);
        incomeSource.setBalance(0);
        incomeSource.setAccount(accountRepository.findById(accountId).orElseThrow(JarsManagementException::AccountNotFound));
        incomeSourceRepository.save(incomeSource);

        return IncomeSourceMapper.INSTANCE.mapToDto(incomeSourceRepository.save(incomeSource));
    }

    @Override
    public List<IncomeSourceDTO> findByIncomeSourceNameAndAccountId(String name, int accountId) {
        return IncomeSourceMapper.INSTANCE.mapToDtos(incomeSourceRepository.findByNameAndAccountId(name, accountId));
    }

    @Override
    public void increaseBalance(int incomeSourceId, double amount) {
        IncomeSource incomeSource = incomeSourceRepository.findById(incomeSourceId).orElseThrow(JarsManagementException::IncomeSourceNotFound);
        incomeSource.setBalance(incomeSource.getBalance() + amount);
        incomeSourceRepository.save(incomeSource);
    }

    @Override
    public void decreaseBalance(int incomeSourceId, double amount) {
        IncomeSource incomeSource = incomeSourceRepository.findById(incomeSourceId).orElseThrow(JarsManagementException::IncomeSourceNotFound);
        incomeSource.setBalance(incomeSource.getBalance() - amount);
        incomeSourceRepository.save(incomeSource);
    }

    //    @Override
//    public List<IncomeSourceDetailDTO> listIncomeSourceBetweenTwoDay(LocalDate start, LocalDate end) {
//List<>
//        return null;
//    }


}
