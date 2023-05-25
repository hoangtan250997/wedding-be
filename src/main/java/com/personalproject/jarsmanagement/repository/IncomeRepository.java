package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IncomeRepository extends JpaRepository<Income,Integer> {
    @Query("SELECT s.name " +
            "FROM  Income i, IncomeSource s " +
            "WHERE i.incomeSource.id = s.id " +
            "AND i.user.id = ?1")
    List<String> listIncomeSourceByUserId(int userId);
}
