package com.Bankig_Application_new.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bankig_Application_new.DTO.AccountDTO;
import com.Bankig_Application_new.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

 
}
