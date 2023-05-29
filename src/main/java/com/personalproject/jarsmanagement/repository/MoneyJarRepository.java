package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface MoneyJarRepository extends JpaRepository<MoneyJar,Integer> {
    @Query("SELECT m " +
            "FROM MoneyJar m " +
            "WHERE m.account.id = ?1 AND m.jarType = ?2")
    MoneyJar findByAccountIdAndJarType(int accountId, JarType jarType);
}
