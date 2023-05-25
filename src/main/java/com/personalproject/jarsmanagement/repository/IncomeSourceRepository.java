package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.IncomeSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IncomeSourceRepository extends JpaRepository<IncomeSource,Integer> {

    IncomeSource findByName(String name);

}
