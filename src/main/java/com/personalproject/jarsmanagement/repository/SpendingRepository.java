package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SpendingRepository extends JpaRepository<Spending,Integer> {
}
