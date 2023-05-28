package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Income;
import com.personalproject.jarsmanagement.service.DTO.Cau2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface IncomeRepository extends JpaRepository<Income, Integer> {

    List<Income> findByReceivedTimeBetween(LocalDate start, LocalDate end);

    @Query(value = "SELECT new com.personalproject.jarsmanagement.service.DTO.Cau2(i.income_source_id ,SUM(i.amount)) " +
            "FROM income i " +
            "WHERE  i.received_time BETWEEN ?1 and ?2 " +
            "GROUP BY i.income_source_id ", nativeQuery = true)
    List<Cau2> cau2(LocalDate start, LocalDate end);
}
