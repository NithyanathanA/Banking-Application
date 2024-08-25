package com.Bankig_Application_new.DTO;

import com.Bankig_Application_new.model.Account;

import lombok.Data;

@Data
public class AccountDTO {
	
    private Long id;
	
	
	private String accountHolderName;
	
	private double balance;

	public AccountDTO(Long id, String accountHolderName, double balance) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	



	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public double getBalance() {
		return balance;
	}






}