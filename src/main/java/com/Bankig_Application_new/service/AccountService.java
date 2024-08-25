package com.Bankig_Application_new.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.Bankig_Application_new.DTO.AccountDTO;
import com.Bankig_Application_new.model.Account;

public interface AccountService {
	
	AccountDTO creatAccount(AccountDTO account);
	
	AccountDTO getAccountById(Long id);
	
	AccountDTO deposit(Long id,double amount);
	
	AccountDTO withdraw(Long id,double amount);
	
	List<AccountDTO> getAll();
	
	void deletdAccont(Long id);

//	AccountDTO findByaccountHolderName(String name);

}
