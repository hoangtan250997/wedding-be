package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.UserRoleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleAssignmentRepository extends JpaRepository<UserRoleAssignment, Integer> {
//    @Query("select u from UserRoleAssignment u where u.user.username = ?1")
//    List<UserRoleAssignment> getByUsername(String username);



}
