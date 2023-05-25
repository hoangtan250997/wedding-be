package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Jars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JarsRepository extends JpaRepository<Jars,Integer> {
}
