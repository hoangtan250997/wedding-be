package com.personalproject.jarsmanagement.repository;

import com.personalproject.jarsmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
@Query("SELECT a " +
        "FROM Account a " +
        "WHERE a.user.username=?1")
    Account findByToken(String token);

}
