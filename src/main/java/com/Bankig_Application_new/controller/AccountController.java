package com.Bankig_Application_new.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bankig_Application_new.DTO.AccountDTO;
import com.Bankig_Application_new.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountservice;
	
	
	
	
	@PostMapping
	public ResponseEntity<AccountDTO> addcount(@RequestBody AccountDTO accountdto){
		return new ResponseEntity<>(accountservice.creatAccount(accountdto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
		AccountDTO accountDto=accountservice.getAccountById(id); 
		
		return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO>depasit(@PathVariable Long id,@RequestBody  Map<String,Double> request){
		Double amount=request.get("amount");
		AccountDTO accountdto=accountservice.deposit(id, amount);
		return ResponseEntity.ok(accountdto);
	}
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDTO>withdraw(@PathVariable Long id,@RequestBody  Map<String,Double> request){
		Double amount=request.get("amount");
		AccountDTO accountdto=accountservice.withdraw(id, amount);
		return ResponseEntity.ok(accountdto);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDTO>>getAllAccots(){
		
		List<AccountDTO>lists=accountservice.getAll();
		
		return ResponseEntity.ok(lists);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteAccot(@PathVariable Long id){
		accountservice.deletdAccont(id);
		return ResponseEntity.ok("the account delete successfully");
	}

}
