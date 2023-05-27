package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.MoneyJar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MoneyJarRepository extends JpaRepository<MoneyJar,Integer> {
}