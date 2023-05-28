package com.personalproject.jarsmanagement.service;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.service.DTO.Cau2;
import com.personalproject.jarsmanagement.service.DTO.IncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDetailDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

public interface IncomeService {
    Income createIncome(IncomeDTO incomeDTO, int accountId);

    //    List<String> listIncomeSourceByAccountId(int accountId);
//
//    List<IncomeDTO> findByIncomeSourceIdAndAccountId(int incomeSourceId, int accountId);
    Double totalIncomeBetweenTwoDay(LocalDate start, LocalDate end);


    List<Income> findByReceivedTimeBetween(LocalDate start, LocalDate end);

    List<Cau2> cau2(LocalDate start, LocalDate end);

    Income findById(int id);
}
