package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Account;
import com.personalproject.jarsmanagement.entity.JarType;
import com.personalproject.jarsmanagement.entity.MoneyJar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MoneyJarRepository extends JpaRepository<MoneyJar,Integer> {

    MoneyJar findByAccountIdAndJarType(int accountId, JarType jarType);

    List<MoneyJar> findByAccount(Account account);
}
