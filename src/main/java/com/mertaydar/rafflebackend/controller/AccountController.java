package com.mertaydar.rafflebackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mertaydar.rafflebackend.repository.AccountRepository;
import com.mertaydar.rafflebackend.exceptions.AccountNotFoundException;
import com.mertaydar.rafflebackend.model.Account;

@RestController
public class AccountController {

	private final AccountRepository repository;

	  AccountController(AccountRepository account) {
	    this.repository = account;
	  }
	  
	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/accounts")
	  List<Account> all() {
	    return repository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/accounts")
	  Account newAccount(@RequestBody Account newAccount) {
	    return repository.save(newAccount);
	  }

	  // Single item

	  @GetMapping("/accounts/{id}")
	  Account one(@PathVariable String id) {

	    return repository.findById(id)
	      .orElseThrow(() -> new AccountNotFoundException(id));
	  }

	  @PutMapping("/accounts/{id}")
	  Account replaceAccount(@RequestBody Account newAccount, @PathVariable String id) {

	    return repository.findById(id)
	      .map(Account -> {
	        Account.setNickname(newAccount.getNickname());
	        Account.setLinks(newAccount.getLinks());
	        return repository.save(Account);
	      })
	      .orElseGet(() -> {
	        newAccount.setNickname(id);
	        return repository.save(newAccount);
	      });
	  }

	  @DeleteMapping("/accounts/{id}")
	  void deleteAccount(@PathVariable String id) {
	    repository.deleteById(id);
	  }
}
