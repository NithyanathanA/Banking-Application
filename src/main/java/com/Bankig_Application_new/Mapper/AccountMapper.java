package com.Bankig_Application_new.Mapper;

import com.Bankig_Application_new.DTO.AccountDTO;
import com.Bankig_Application_new.model.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDTO accountDto) {
		
		Account account=new Account(
				accountDto.getId(),
				accountDto.getAccountHolderName(),
				accountDto.getBalance());
		
		
		return account;
		
	}
	
	public static AccountDTO maptoAccountDto(Account account) {
		
		AccountDTO accountdto=new AccountDTO(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance());
		
		return accountdto;
	}

}
