package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Spending;
import com.personalproject.jarsmanagement.service.DTO.Spending.JarDTO;
import com.personalproject.jarsmanagement.service.DTO.Spending.PurposeDTO;
import com.personalproject.jarsmanagement.service.DTO.SpendingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpendingRepository extends JpaRepository<Spending, Integer> {
    @Query("SELECT new com.personalproject.jarsmanagement.service.DTO.Spending.JarDTO(s.account.id, s.moneyJar.jarType, sum(s.amount)) " +
            "FROM Spending s " +
            "WHERE s.spendingTime BETWEEN ?1 AND ?2 " +
            "GROUP BY s.account.id, s.moneyJar.jarType " +
            "ORDER BY s.account.id")
    List<JarDTO> listJarsBetweenTwoDays(LocalDate start, LocalDate end);

    @Query("SELECT new com.personalproject.jarsmanagement.service.DTO.Spending.JarDTO(s.account.id, s.moneyJar.jarType, sum(s.amount)) " +
            "FROM Spending s " +
            "WHERE (s.spendingTime BETWEEN ?1 AND ?2) AND s.account.id=?3 " +
            "GROUP BY s.account.id, s.moneyJar.jarType " +
            "ORDER BY sum(s.amount) DESC")
    List<JarDTO> listJarsByAccountIdBetweenTwoDays(LocalDate start, LocalDate end, int accountId);

    @Query("SELECT new com.personalproject.jarsmanagement.service.DTO.Spending.PurposeDTO(s.account.id, s.purpose, sum(s.amount)) " +
            "FROM Spending s " +
            "WHERE s.spendingTime BETWEEN ?1 AND ?2 AND s.account.id=?3 " +
            "GROUP BY s.account.id, s.purpose " +
            "ORDER BY SUM(s.amount) DESC")
    List<PurposeDTO> listPurposeByAccountIdBetweenTwoDays(LocalDate start, LocalDate end,int accountId);
    @Query("SELECT s " +
            "FROM Spending s " +
            "WHERE s.spendingTime BETWEEN ?1 AND ?2 AND s.account.id=?3 ")
    List<SpendingDTO> getSpendingListByAccountIdBetweenTwoDays(LocalDate start, LocalDate end, int accountId);
    @Query("SELECT new com.personalproject.jarsmanagement.service.DTO.Spending.PurposeDTO(s.account.id, s.purpose, sum(s.amount)) " +
            "FROM Spending s " +
            "WHERE EXTRACT(MONTH FROm s.spendingTime) = ?2 AND s.account.id =?1 " +
            "GROUP BY s.account.id, s.purpose " +
            "ORDER BY SUM(s.amount) DESC")
    List<PurposeDTO> listPurposeByAccountIdByMonthNumber(int accountId,int monthNum);


}
