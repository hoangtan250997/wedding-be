package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.entity.IncomeSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IncomeSourceRepository extends JpaRepository<IncomeSource, Integer> {

    IncomeSource findByName(String name);

    //        @Query("SELECT i " +
//            "FROM IncomeSource i " +
//            "WHERE i.name = ?1 " +
//            "AND i.account.id = ?2 ")
    List<IncomeSource> findByNameAndAccountId(String incomeSourceName, int accountId);

    List<IncomeSource> findByAccount(Account account);
}
