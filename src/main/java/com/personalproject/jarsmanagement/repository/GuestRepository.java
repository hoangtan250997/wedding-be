package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GuestRepository extends JpaRepository<GuestEntity, Integer> {


}
