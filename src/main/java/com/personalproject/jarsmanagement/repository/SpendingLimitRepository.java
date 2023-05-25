package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.SpendingLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SpendingLimitRepository extends JpaRepository<SpendingLimit,Integer> {
}
