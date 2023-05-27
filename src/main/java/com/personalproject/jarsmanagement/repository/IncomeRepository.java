package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IncomeRepository extends JpaRepository<Income, Integer> {
    @Query("SELECT DISTINCT s.name " +
            "FROM  Income i, IncomeSource s " +
            "WHERE i.incomeSource.id = s.id " +
            "AND i.account.id = ?1")
    List<String> listIncomeSourceByAccountId(int accountId);

    @Query("SELECT i " +
            "FROM Income i " +
            "WHERE i.incomeSource.id = ?1 " +
            "AND i.account.id = ?2 ")
    List<Income> findByIncomeSourceIdAndAccountId(int incomeSourceId, int accountId);

}
