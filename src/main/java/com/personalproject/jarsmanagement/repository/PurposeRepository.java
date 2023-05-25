package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PurposeRepository extends JpaRepository<Purpose,Integer> {
}
