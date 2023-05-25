package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Assign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AssignRepository extends JpaRepository<Assign,Integer> {

}
