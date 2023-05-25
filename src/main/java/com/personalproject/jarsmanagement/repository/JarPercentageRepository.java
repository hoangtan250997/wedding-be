package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.JarPercentage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JarPercentageRepository extends JpaRepository<JarPercentage ,Integer> {

}
