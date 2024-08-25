package com.Bankig_Application_new.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bankig_Application_new.DTO.AccountDTO;
import com.Bankig_Application_new.Mapper.AccountMapper;
import com.Bankig_Application_new.Repo.AccountRepository;
import com.Bankig_Application_new.model.Account;


@Service
public class AccountServiceImpL implements AccountService {
	
	@Autowired
	private AccountRepository accountrepo;

	@Override
	public AccountDTO creatAccount(AccountDTO accountDTO) {
		Account account=AccountMapper.mapToAccount(accountDTO);
		
		Account saveaccount =accountrepo.save(account);
		
		return AccountMapper.maptoAccountDto(saveaccount);
	}

	@Override
	public AccountDTO getAccountById(Long id) {
	Account account=	accountrepo.findById(id).orElseThrow(()->new RuntimeException("Account exits"));
		return AccountMapper.maptoAccountDto(account);
	}

	@Override
	public AccountDTO deposit(Long id, double amount) {
		Account account=	accountrepo.findById(id).orElseThrow(()->new RuntimeException("Account exits"));
		
		double total= account.getBalance()+amount;
		account.setBalance(total);
	Account account1=accountrepo.save(account);
		return AccountMapper.maptoAccountDto(account1);
	}

	@Override
	public AccountDTO withdraw(Long id, double amount) {
		Account account=accountrepo.findById(id).orElseThrow(()->new RuntimeException("Account exits"));
		
		
		if(account.getBalance()<amount)
			throw new RuntimeException("insuffient amount");
		
		double total=account.getBalance()-amount;
		account.setBalance(total);
		Account account1=accountrepo.save(account);
		return AccountMapper.maptoAccountDto(account1);
	}

	@Override
	public List<AccountDTO> getAll() {
		List<Account>accounts=accountrepo.findAll();
		
		return accounts.stream().map((account)->AccountMapper.maptoAccountDto(account))
		.collect(Collectors.toList());
	}

	@Override
	public void deletdAccont(Long id) {
		Account account=	accountrepo.findById(id).orElseThrow(()->new RuntimeException("Account exits"));
		
		accountrepo.deleteById(id);
		
		
	}
	
	
	
	
	
	

	


}
