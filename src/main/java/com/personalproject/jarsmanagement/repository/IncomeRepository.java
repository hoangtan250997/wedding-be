package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.service.DTO.Income.IdAmountIncomeDTO;
import com.personalproject.jarsmanagement.service.DTO.Income.idAmountNameIncomeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface IncomeRepository extends JpaRepository<Income, Integer> {

    List<Income> findByReceivedTimeBetween(LocalDate start, LocalDate end);


    @Query("SELECT new com.personalproject.jarsmanagement.service.DTO.Income.IdAmountIncomeDTO(i2.account.id, sum(i.amount)) " +
            "FROM Income i, IncomeSource i2 " +
            "WHERE i.receivedTime BETWEEN ?1 AND ?2 " +
            "GROUP BY i2.account.id ")
    List<IdAmountIncomeDTO> listIdAmountIncomeDTO(LocalDate start, LocalDate end);

    @Query("SELECT new com.personalproject.jarsmanagement.service.DTO.Income.idAmountNameIncomeDTO(i2.account.id, i2.name, sum(i.amount)) " +
            "FROM Income i, IncomeSource i2 " +
            "WHERE i.receivedTime BETWEEN ?1 AND ?2 " +
            "GROUP BY i2.account.id, i2.name ")
    List<idAmountNameIncomeDTO> listIdAmountNameIncome(LocalDate start, LocalDate end);
}
