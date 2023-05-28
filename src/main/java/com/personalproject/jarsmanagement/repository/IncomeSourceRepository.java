package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.entity.IncomeSource;
import com.personalproject.jarsmanagement.service.DTO.IncomeSourceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IncomeSourceRepository extends JpaRepository<IncomeSource, Integer> {
    IncomeSource findByName(String name);

    List<IncomeSource> findByAccount(Account account);

    List<IncomeSource> findByNameAndAccountId(String incomeSourceName, int accountId);

}
