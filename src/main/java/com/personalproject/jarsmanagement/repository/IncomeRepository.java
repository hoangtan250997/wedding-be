package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IncomeRepository extends JpaRepository<Income, Integer> {
    @Query("SELECT s.name " +
            "FROM  Income i, IncomeSource s " +
            "WHERE i.incomeSource.id = s.id " +
            "AND i.user.id = ?1")
    List<String> listIncomeSourceByUserId(int userId);

    @Query("SELECT i " +
            "FROM Income i " +
            "WHERE i.incomeSource.id = ?1 " +
            "AND i.user.id = ?2 ")
    List<Income> findByIncomeSourceIdAndUserId(int incomeSourceId, int userId);

}
